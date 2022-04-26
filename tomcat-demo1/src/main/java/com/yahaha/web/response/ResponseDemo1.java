package com.yahaha.web.response;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/resp1")
public class ResponseDemo1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("resp1...");

        //重定向至resp2
        //1 设置响应码
//        response.setStatus(302);
//        //2 设置响应头
//        response.setHeader("Location","/tomcat_demo1_war/resp2");
//redirest到内部资源
        String contextPath = request.getContextPath();
        response.sendRedirect(contextPath+"/resp2");
        //redirect到外部资源
//        response.sendRedirect("https://www.baidu.com");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
