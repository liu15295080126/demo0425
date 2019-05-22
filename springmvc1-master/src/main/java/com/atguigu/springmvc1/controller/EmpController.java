package com.atguigu.springmvc1.controller;

import com.atguigu.springmvc1.entity.User;
import com.atguigu.springmvc1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

/**
 * @author chengLiu
 * @createTime 2019-05-21 21:37
 */
@Controller
public class EmpController {
    @Autowired
    private UserService userService;
    //查询所有员工，返回列表页面
    @GetMapping("/emps")
    public String list(Model model){
        Collection<User> users=userService.listAll();
        model.addAttribute("emps",users);
        return "emp/list";
    }
    @GetMapping("/emp/{id}")
    public String toEditPage(@PathVariable("id")Integer id, Model model){
       User user=userService.selectUserById(id);
        model.addAttribute("emp",user);
        return "emp/edit";
    }
    @GetMapping("/emp")
    public String toAddPage( ){
        return "emp/edit";
    }

    @PostMapping("/emp")
    public String editEmp(User user){
        System.out.println("editEmp");
        System.out.println(user);
       User emp=userService.selectUserByUserName(user.getUsername());
        if (emp != null) {
            user.setId(emp.getId());
            userService.updateUserById(user);
        }else {
            userService.addUser(user);
        }
        return "redirect:/emps";
    }
    // 删除员工
    @PostMapping("/emp/delete/{id}")
    public String deleteEmployee(@PathVariable("id") Integer id) {
        userService.deleteUserById(id);
        return "redirect:/emps";
    }
}
