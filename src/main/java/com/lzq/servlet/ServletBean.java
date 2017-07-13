package com.lzq.servlet;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

/**
 * @author:lzq
 * @discription
 * @since: Created on 2017/7/13 14:16.
 */
@Configuration
public class ServletBean {
    @Bean
    public ServletRegistrationBean myServletRegistrationBean() {
        ServletRegistrationBean registrationBean = new ServletRegistrationBean();
        registrationBean.setServlet(new DemoServlet());
        List<String> urlMappings=new ArrayList<String>();
        urlMappings.add("/demoservlet");
        registrationBean.setUrlMappings(urlMappings);
        return registrationBean;
    }
}
