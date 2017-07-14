package com.lzq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * @author:lzq
 * @discription
 * @since: Created on 2017/7/13 12:00.
 */
@SpringBootApplication
@ServletComponentScan
public class AmqMessageApplication {
    public static void main(String[] args) {
        SpringApplication.run(AmqMessageApplication.class, args);
    }
}
