package com.atguigu.springmvc1.controller;

import com.atguigu.springmvc1.entity.User;
import com.atguigu.springmvc1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    public UserService userService;
    //查询所有用户，返回列表页面
    @GetMapping(value = "/listAll")
    public List<User> listAll() {
        return userService.listAll();
    }

    @GetMapping(value = "/selectUserById")
    public User selectUserById(Integer id) {
        return userService.selectUserById(id);
    }

    @GetMapping(value = "/selectUserByName")
    public List<User> selectUserByName(String name) {
        return userService.selectUserByName(name);
    }

    @PostMapping(value = "/addUser")
    public Map<String, Object> addUser(User user) {
        Map<String, Object> map = new HashMap<String, Object>();
//        User user=new User();
//        user.setName(name);
//        user.setAddress(address);
        if (userService.addUser(user) > 0) {
            map.put("success", user);
        } else {
            map.put("error", 0);
        }
        return map;
    }

    @DeleteMapping(value = "/deleteUser")
    public Map<String, Object> deleteUserById(Integer id) {
        Map<String, Object> map = new HashMap<String, Object>();
        if (userService.deleteUserById(id) > 0) {
            map.put("success", id);
        } else {
            map.put("error", 0);
        }
        return map;
    }

    @PostMapping(value = "/updateUserById")
    public Map<String, Object> updateUserById(User user) {
        Map<String, Object> map = new HashMap<String, Object>();
        if (userService.updateUserById(user) > 0) {
            map.put("success", user);
        } else {
            map.put("error", 0);
        }
        return map;
    }
}
