package com.lzq.jms;//package com.my.jms;//package com.com.business.jms;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * @author lzq
 * @version 1.0
 * @description 消费者
 * @since 2017/5/10 23:48
 */
@Service
public class Consumer {

    @JmsListener(destination = "amq.test")
    public void receiveWatchInput(String text) throws IOException {

        System.out.println("consumer received message :" + text);
    }
}
