package com.demo.link.protocol;

import com.demo.link.process.ProtocolLink;
import com.demo.link.vo.VoOneIn;
import com.demo.link.vo.VoOneO;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by liumy on 2016/8/21.
 */
public class AssertionOrderType {

    public  List<ProtocolLink<VoOneO,VoOneIn>> process(ProtocolLink<VoOneIn,VoOneO> object){
        System.out.println("第一层处理完成");
        List<ProtocolLink<VoOneO,VoOneIn>> links=new LinkedList<ProtocolLink<VoOneO,VoOneIn>>();
        ProtocolLink <VoOneO, VoOneIn> protocolLink= new ProtocolLink<VoOneO, VoOneIn>();
        protocolLink.setFlag(1);
        protocolLink.setClassPath("com.demo.link.protocol.AssertionOrderTypeNext");
        protocolLink.setNextParam(new VoOneIn());
        protocolLink.setMethod("process");
        //模拟需要20个分支处理
        for(int i=0;i<20;i++){
            links.add(protocolLink);
        }
        return  links;
    }



}
