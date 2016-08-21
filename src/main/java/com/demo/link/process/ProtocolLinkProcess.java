package com.demo.link.process;


import com.demo.link.vo.VoOneIn;
import com.demo.link.vo.VoOneO;

import java.lang.reflect.Method;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by liumy on 2016/8/21.
 */
public class ProtocolLinkProcess {


    private ExecutorService exec = Executors.newFixedThreadPool(10);

    private static Lock lock = new ReentrantLock();

    public void process(String classPath, String method, ProtocolLink protocolLink) {

        try {
            Class clz = Class.forName(classPath);
            Method meth = clz.getDeclaredMethod(method, new Class[]{ProtocolLink.class});
            Object res = meth.invoke(clz.newInstance(), protocolLink);
            List<ProtocolLink> protocol = (List<ProtocolLink>) res;
            //判断程序运行终止条件，所有协议层flag都是0,否则分发节点到一个线程
            decisionTermination(protocol);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            exec.shutdown();
        }
    }

    private boolean decisionTermination(List<ProtocolLink> protocol) {
        int flag = 0;
        try {
            lock.lock();
            for (final ProtocolLink protocolLink1 : protocol) {
                if (protocolLink1.getFlag() == 0) {
                    flag++;
                } else {
                    //分发节点到一个新的线程
                    Runnable run = new Runnable() {
                        public void run() {
                            try {
                                process(protocolLink1.getClassPath(), protocolLink1.getMethod(), protocolLink1);

                            } catch (Exception e) {
                            }
                        }
                    };
                    exec.execute(run);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

        if (flag == protocol.size()) {
            return true;
        }
        return false;

    }


    public static void main(String[] args) {
        ProtocolLink<VoOneIn, VoOneO> protocolLink = new ProtocolLink<VoOneIn, VoOneO>();
        long time = System.currentTimeMillis();
        try {
            new ProtocolLinkProcess().process("com.demo.link.protocol.AssertionOrderType", "process", protocolLink);
            long time1 = System.currentTimeMillis();
            System.out.println("=======完成======耗时:" + (time1 - time) + "ms");
        } catch (Exception e) {
            e.printStackTrace();
        }


    }


}
