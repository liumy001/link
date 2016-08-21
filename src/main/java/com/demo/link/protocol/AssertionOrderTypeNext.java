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

    public  List<ProtocolLink<VoOneIn,VoOneO>> process(ProtocolLink<VoOneIn,VoOneO> object){
        System.out.println("------------------------");
        List<ProtocolLink<VoOneIn,VoOneO>> links=new LinkedList<ProtocolLink<VoOneIn, VoOneO>>();
        links.add(new ProtocolLink<VoOneIn, VoOneO>());
        System.out.println("------------------------");
        return  links;
    }



}
