package com.yahaha.web;

import com.yahaha.mapper.UserMapper;
import com.yahaha.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

@WebServlet("/registerServlet")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //接受用户名密码
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        //封装用户对象
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);

        //2. 调用MyBatis完成查询
//2.1 获取SqlSessionFactory对象
        String resource = "mybatis-config.xml";
        InputStream inputStream;
        inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new
                SqlSessionFactoryBuilder().build(inputStream);
//2.2 获取SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
//2.3 获取Mapper
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        //2.4 调用方法
        User u = userMapper.selectByUsername(username);
//3. 判断用户对象是否为null
        if (u == null) {
            userMapper.add(user);
// 提交事务
            sqlSession.commit();
// 释放资源
            sqlSession.close();
// 用户名不存在，添加用户

        }else {
            // 用户名存在，给出提示信息
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().write("用户名已存在");
        }
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        this.doGet(request, response);
    }
}

