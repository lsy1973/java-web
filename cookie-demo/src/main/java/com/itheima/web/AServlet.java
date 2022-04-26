package com.itheima.web;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "AServlet", value = "/AServlet")
public class AServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //创建cookie
        Cookie cookie = new Cookie("username","zhangsan");

        //设置存活时间
        //正数 秒；负数，默认值，浏览器关闭 cookie结束；
        cookie.setMaxAge(60*60*24*7); //易阅读，需程序计算
//cookie.setMaxAge(604800); //不易阅读(可以使用注解弥补)，程序少进行一次计算
        //send cookie
        response.addCookie(cookie);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
