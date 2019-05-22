package com.atguigu.springmvc1.controller;

import com.atguigu.springmvc1.entity.User;
import com.atguigu.springmvc1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
@RequestMapping(value = "/user")
public class LoginController {
    @Autowired
    UserService userService;

    @PostMapping(value = "/login")
    public String toLogin(@RequestParam("name") String name, @RequestParam("password") String password,
                          Map<String, Object> map, HttpSession session) {
        User user = userService.selectUserByNameAndPsd(name, password);
        if (user != null) {
            session.setAttribute("loginUser",name);
            return "redirect:/dashboard.html";
        } else {
            map.put("msg", "用户名或密码错误");
            return "login";
        }

    }
}
