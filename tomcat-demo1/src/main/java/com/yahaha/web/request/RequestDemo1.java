package com.yahaha.web.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;


@WebServlet("/req1")
public class RequestDemo1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException{
        String method = req.getMethod();
        System.out.println(method);
        String contextPath = req.getContextPath();
        System.out.println(contextPath);
        StringBuffer requestURL = req.getRequestURL();
        System.out.println(requestURL.toString());
        String requestURI = req.getRequestURI();
        System.out.println(requestURI);
        String queryString = req.getQueryString();
        System.out.println(queryString);


        String header = req.getHeader("User-Agent");
        System.out.println(header);

    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取post 请求体：请求参数
//1. 获取字符输入流
        BufferedReader br = req.getReader();
//2. 读取数据
        String line = br.readLine();
        System.out.println(line);
    }
}
