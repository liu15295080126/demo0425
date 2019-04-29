package com.example.demo0425.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="sysuser")
public class User {
    @Id
    String username;
    String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
