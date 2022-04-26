package com.itheima.web;

import com.itheima.pojo.User;
import com.itheima.service.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/registerServlet")
public class RegisterServlet extends HttpServlet {
    private UserService service = new UserService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1. 获取用户名和密码数据
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        //创建User对象
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        //获取用户输入的验证码
        String checkCode = request.getParameter("checkCode");

// 程序生成的验证码，从Session获取
        HttpSession session = request.getSession();
        String checkCodeGen = (String) session.getAttribute("checkCodeGen");

        // 比对
        if(!checkCodeGen.equalsIgnoreCase(checkCode)) {
            request.setAttribute("register_msg", "验证码错误");
            request.getRequestDispatcher("/register.jsp").forward(request, response);
            return;
        }


        //调用注册方法
        boolean flag = service.register(user);
        //判断是否注册
        if(flag){
            //注册成功
            request.setAttribute("register_msg","注册成功，请登录");
            request.getRequestDispatcher("/login.jsp").forward(request,response);
        }else {
            request.setAttribute("register_msg","注册失败/用户名已存在");
            request.getRequestDispatcher("/register.jsp").forward(request,response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
