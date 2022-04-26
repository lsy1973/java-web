package com.itheima.web;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/bServlet")
public class BServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取cookie数组

        //获取数组
        Cookie[] cookies = request.getCookies();


        //遍历
        for (Cookie cookie : cookies) {

            String name = cookie.getName();
            if("username".equals(name)){
                String val = cookie.getValue();
                System.out.println(name+" "+val);
            }

        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
