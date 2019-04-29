package com.example.demo0425.service;

import com.example.demo0425.dao.UserDao;
import com.example.demo0425.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl {
    @Autowired
    private UserDao userDao;
    public User getUser(String username, String password) {
        return userDao.getByPasswordAndUsername(username,password);

    }

    public void insertUser(User user) {
        userDao.save(user);
    }

}
