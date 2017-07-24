package com.lzq.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author:lzq
 * @discription
 * @since: Created on 2017/7/13 16:30.
 */
@Controller
public class MessageController {
    @RequestMapping("/send")
    public String send() {
        return "send";
    }

    @RequestMapping("/receive")
    public String receive() {
        return "receive";
    }
    @RequestMapping("/chat")
    public String chat() {
        return "chat";
    }

}
