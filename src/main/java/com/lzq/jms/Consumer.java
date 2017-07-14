//package com.lzq.jms;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.jms.annotation.JmsListener;
//import org.springframework.stereotype.Service;
//
//import java.io.IOException;
//
///**
// * @author lzq
// * @version 1.0
// * @description 消费者
// * @since 2017/5/10 23:48
// */
//@Service
//public class Consumer {
//    Logger log = LoggerFactory.getLogger(Consumer.class);
//    private static final String AMQ_DESTINATION = "amq.test";
//
//    @JmsListener(destination = AMQ_DESTINATION)
//    public void receiveWatchInput(String text) throws IOException {
//
//        log.info("consumer received message :" + text);
//    }
//}
