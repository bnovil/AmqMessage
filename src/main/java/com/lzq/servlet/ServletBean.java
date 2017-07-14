package com.lzq.servlet;

import org.apache.activemq.web.AjaxServlet;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import java.util.ArrayList;
import java.util.Collections;
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
        urlMappings.add("/demoServlet");
        registrationBean.setUrlMappings(urlMappings);
        return registrationBean;
    }

    @Bean
    public ServletRegistrationBean amqServletRegistrationBean() {
        ServletRegistrationBean registrationBean = new ServletRegistrationBean();
        registrationBean.setServlet(new AjaxServlet());
        registrationBean.setLoadOnStartup(1);
        List<String> urlMappings=new ArrayList<String>();
        urlMappings.add("/amq/*");
        registrationBean.setUrlMappings(urlMappings);
        return registrationBean;
    }

    // configured in the file application.properties
//    @Bean
//    public ServletContextInitializer initializer() {
//        return new ServletContextInitializer() {
//            @Override
//            public void onStartup(ServletContext servletContext) throws ServletException {
//                servletContext.setInitParameter("org.apache.activemq.brokerURL", "tcp://127.0.0.1:61616");
//            }
//        };
//    }
}
