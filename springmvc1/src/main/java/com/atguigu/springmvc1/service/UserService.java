package com.atguigu.springmvc1.service;

import com.atguigu.springmvc1.dao.UserMapper;
import com.atguigu.springmvc1.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    public UserMapper userMapper;

    public List<User> listAll() {
        return userMapper.listAll();
    }
    public User selectUserById(Integer id){
        return userMapper.selectUserById(id);
    }
    public List<User> selectUserByName(String name){
        return userMapper.selectUserByName(name);
    }
    public User selectUserByNameAndPsd(String name,String password){
        return userMapper.selectUserByNameAndPsd(name,password);
    }
    public Integer addUser(User user){
        return userMapper.addUser(user);
    }
    public Integer deleteUserById(Integer id){
        return userMapper.deleteUserById(id);
    }
    public Integer updateUserById(User user){
        return userMapper.updateUserById(user);
    }
}
