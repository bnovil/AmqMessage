package com.lzq.servlet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author:lzq
 * @discription
 * @since: Created on 2017/7/13 14:11.
 */
public class DemoServlet extends HttpServlet {
    Logger log = LoggerFactory.getLogger(DemoServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        log.info("==>DemoServlet接受请求");
        resp.getWriter().write("DemoServlet access success");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        this.doGet(req, resp);
    }

}