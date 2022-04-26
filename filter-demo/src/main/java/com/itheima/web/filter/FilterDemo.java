package com.itheima.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter("/hello.jsp")
public class FilterDemo implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("1.FilterDemo===");

        //放行
        filterChain.doFilter(servletRequest,servletResponse);

        //放行后
        System.out.println("3.filter demo");
    }

    @Override
    public void destroy() {

    }
}
