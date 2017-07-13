package com.lzq.jms;//package com.com.business.jms;
//
//import org.springframework.jms.core.JmsTemplate;
//import org.springframework.stereotype.Service;
//
//import javax.annotation.Resource;
//import javax.jms.Destination;
//
///**
// * @author lzq
// * @version 1.0
// * @description 消息生产者
// * @since 2017/5/10 23:18
// */
//@Service
//public class Producer {
//
//    @Resource
//    private JmsTemplate jmsTemplate;
//
//    public void sendMessage(Destination destination, String message) {
//        jmsTemplate.convertAndSend(destination, message);
//    }
//
////    @JmsListener(destination = "out.queue")
////    public void consumerMessage(String text) {
////        System.out.println("从out.queue队列收到的回复报文为:" + text);
////    }
//
//}
