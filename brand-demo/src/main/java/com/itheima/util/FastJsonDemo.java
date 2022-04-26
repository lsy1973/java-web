package com.itheima.util;

import com.alibaba.fastjson.JSON;
import com.itheima.pojo.User;

public class FastJsonDemo {
    public static void main(String[] args) {
        //java to json
        User user = new User();
        user.setId(1);
        user.setUsername("liu");
        user.setPassword("123");

        String jsongString = JSON.toJSONString(user);
        System.out.println(jsongString);



        //json to java object
//        User u = JSON.parseObject("{\"id\":1,\"password\":\"123\",\"username\":\"zhangsan\"}", User.class);
//        System.out.println(u);
        User u2 = JSON.parseObject(jsongString,User.class);
        System.out.println(u2);
    }
}
