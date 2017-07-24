package com.lzq.servlet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.Enumeration;

/**
 * @author:lzq
 * @discription
 * @since: Created on 2017/7/13 14:11.
 */
public class DemoServlet extends HttpServlet {
    Logger log = LoggerFactory.getLogger(DemoServlet.class);

    //servlet是线程不安全的 , 多线程共享变量不安全
    String message;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        log.info("DemoServlet received");
//        局部变量不会被多个线程共享，线程安全
//        String message;
        message = req.getParameter("message");
        System.out.println(Thread.currentThread().getName() + " " + message);

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }



        HttpSession session = req.getSession();
        session.setAttribute("key", "hello");
        ServletContext servletContext = this.getServletContext();
        Enumeration<String> enumeration = servletContext.getInitParameterNames();
        while (enumeration.hasMoreElements()) {
            String name = enumeration.nextElement();
            log.debug("key:{},value:{}", name, servletContext.getInitParameter(name));
        }
        resp.getWriter().write("DemoServlet access success, message is " + message);
        resp.getWriter().close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        this.doGet(req, resp);
    }

}