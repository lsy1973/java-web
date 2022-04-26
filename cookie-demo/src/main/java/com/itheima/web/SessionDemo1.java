package com.itheima.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/demo1")
public class SessionDemo1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse
            response) throws ServletException, IOException {
        //获取session对象，将数据存储到session中
//session是基于cookie实现的
        //1 获取session对象
        HttpSession session = request.getSession();

        //存储数据
        session.setAttribute("username","zhangsansan");


    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse
            response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
