package com.demo.link.protocol;

import com.demo.link.process.ProtocolLink;
import com.demo.link.vo.VoOneIn;
import com.demo.link.vo.VoOneO;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by liumy on 2016/8/21.
 */
public class AssertionOrderTypeThree {

    public  List<ProtocolLink<VoOneIn,VoOneO>> process(ProtocolLink<VoOneIn,VoOneO> object){
        List<ProtocolLink<VoOneIn,VoOneO>> links=new LinkedList<ProtocolLink<VoOneIn, VoOneO>>();
        for(int i=0;i<1;i++){
            System.out.println("第三层处理完成");
        }
        return  links;
    }



}
