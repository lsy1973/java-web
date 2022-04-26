package com.yahaha.web.request;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Map;

@WebServlet("/req2")
public class RequestDemo2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //GET请求逻辑
//        System.out.println("Get....");
//1. 获取所有参数的Map集合
        Map<String, String[]> map = request.getParameterMap();
        for (String key : map.keySet()) {
// username:zhangsan lisi
            System.out.print(key + ":");
//获取值
            String[] values = map.get(key);
            for (String value : values) {
                System.out.print(value + " ");
            }
//            System.out.println("=======================");
            String[] hobbies = request.getParameterValues("hobby");
            for (String hobby : hobbies) {
                System.out.println(hobby);
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        System.out.println("Post...");
        this.doGet(request, response);
    }
}
