package com.demo.link.protocol;

import com.demo.link.process.ProtocolLink;
import com.demo.link.vo.VoOneIn;
import com.demo.link.vo.VoOneO;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by liumy on 2016/8/21.
 */
public class AssertionOrderTypeNext {

    public  List<ProtocolLink<VoOneO,VoOneIn>> process(ProtocolLink<VoOneIn,VoOneO> object){
        System.out.println("haha");
        List<ProtocolLink<VoOneO,VoOneIn>> links=new LinkedList<ProtocolLink<VoOneO,VoOneIn>>();
        ProtocolLink <VoOneO, VoOneIn> protocolLink= new ProtocolLink<VoOneO, VoOneIn>();
        protocolLink.setFlag(1);
        protocolLink.setClassPath("com.demo.link.protocol.AssertionOrderTypeThree");
        protocolLink.setNextParam(new VoOneIn());
        protocolLink.setMethod("process");

        for(int i=0;i<100;i++){
            links.add(protocolLink);
        }

        for(int i=0;i<1;i++){
            System.out.println("第二层处理完成");
        }
        return  links;
    }



}
