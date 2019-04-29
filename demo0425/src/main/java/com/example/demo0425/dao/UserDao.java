package com.example.demo0425.dao;

import com.example.demo0425.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User,Integer> {
    public User getByPasswordAndUsername(String username,String password);
}
