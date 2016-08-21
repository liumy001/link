package com.demo.link.process;

/**
 * Created by liumy on 2016/8/21.
 */
public class ProtocolLink<Q,T extends Object> {


    //上一层协议处理结果
    private  String result;

    //本层协议链需要的参数
    private  Q param;

    //供应新协议处理参数
    private  T  nextParam;

    //下一层协议链处理类路径
    private  String classPath;

    //下一层协议处理的方法名
    private  String method;

    //层链终止标识
    private  int flag=0;


    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public Q getParam() {
        return param;
    }

    public void setParam(Q param) {
        this.param = param;
    }

    public T getNextParam() {
        return nextParam;
    }

    public void setNextParam(T nextParam) {
        this.nextParam = nextParam;
    }

    public String getClassPath() {
        return classPath;
    }

    public void setClassPath(String classPath) {
        this.classPath = classPath;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }
}
