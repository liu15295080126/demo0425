package com.example.demo0425.controller;

import com.example.demo0425.entity.User;
import com.example.demo0425.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
public class UserController {
    @Autowired
    UserServiceImpl userServiceImpl;
    @RequestMapping("/login")
    public String login(){
        return "login";
    }

    @RequestMapping("doLogin")
    public String doLogin(User user, Map<String,Object> map){
        User user1 =  userServiceImpl.getUser(user.getPassword(),user.getUsername());
        if(user1 == null){
            map.put("msg","登入失败");
        }else{
            map.put("msg","登入成功");
        }
        return "home";
    }
    @RequestMapping("/regist")
    public String regist(){
        return "regist";
    }

    @RequestMapping("doRegist")
    public String doRegist(User user, Map<String,Object> map){
        userServiceImpl.insertUser(user);
        map.put("msg","注册成功");
        return "home";
    }
}
