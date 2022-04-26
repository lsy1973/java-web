package com.itheima.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/hello.jsp")
public class LoginFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest req = (HttpServletRequest)request;
        //判断用户是否存在
        HttpSession session = req.getSession();
        Object user = session.getAttribute("user");
        //判断用户是否为空
        if(user!=null){
            chain.doFilter(request, response);
        }else {
            req.setAttribute("login_msg","您尚未登录");
            req.getRequestDispatcher("/login.jsp").forward(req,response);
        }


        chain.doFilter(request, response);
    }
}
