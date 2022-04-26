package com.itheima.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/*")
public class LoginFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest req = (HttpServletRequest)request;
        //判断访问资源路径是否和登录注册相关
//1,在数组中存储登陆和注册相关的资源路径
        String[] urls =
                {"/login.jsp","/imgs/","/css/","/loginServlet","/register.jsp","/registerServlet","/checkCodeServlet"};
//2,获取当前访问的资源路径
        String url = req.getRequestURL().toString();
//3,遍历数组，获取到每一个需要放行的资源路径
        for (String u : urls) {
//4,判断当前访问的资源路径字符串是否包含要放行的的资源路径字符串
/*
比如当前访问的资源路径是 /brand-demo/login.jsp
而字符串 /brand-demo/login.jsp 包含了 字符串 /login.jsp ，所以这个字符串就需要放行
*/
            if(url.contains(u)){
//找到了，放行
                chain.doFilter(request, response);
//break;
                return;
            }
        }
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


//        chain.doFilter(request, response);
    }
}
