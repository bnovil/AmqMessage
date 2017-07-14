package com.lzq.jms;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.jms.Destination;

/**
 * @author lzq
 * @version 1.0
 * @description 消息生产者
 * @since 2017/5/10 23:18
 */
@Service
public class Producer {

    @Resource
    private JmsTemplate jmsTemplate;

    public void sendMessage(Destination destination, String message) {
        jmsTemplate.convertAndSend(destination, message);
    }

    public void sendMessage(String message) {

//        jmsTemplate.convertAndSend(destination, message);
    }

}
