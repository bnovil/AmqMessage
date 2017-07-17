package com.lzq;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/**
 * @author:lzq
 * @discription
 * @since: Created on 2017/7/17 10:17.
 */
public class AmqServletInitializer extends SpringBootServletInitializer {

    @Override
    public SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(AmqMessageApplication.class);
    }
}
