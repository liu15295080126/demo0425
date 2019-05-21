package com.atguigu.springmvc1.dao;

import com.atguigu.springmvc1.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;
//增删改查
@Mapper
public interface UserMapper {
    //查
    @Select("select * from userinfo")
    List<User> listAll();
    @Select("SELECT * FROM USERINFO WHERE ID=#{ID}")
    User selectUserById(Integer id);
    @Select("SELECT * FROM USERINFO WHERE NAME=#{NAME}")
    List<User> selectUserByName(String name);
    @Select("SELECT * FROM USERINFO WHERE name=#{name} and password=#{password}")
    User selectUserByNameAndPsd(String name,String password);
    //增
    @Insert("INSERT INTO USERINFO (name,address) VALUES(#{name},#{address})")
    @Options(useGeneratedKeys = true, keyProperty = "id")// 在本项目中可以返回插入的自增ID值，若未添加此行代码，数据库中插入数据成功，id也自增，但页面不会返回本条数据的ID值
    Integer addUser(User user);
    //删
    @Delete("DELETE FROM USERINFO WHERE ID=#{ID}")
    Integer deleteUserById(Integer id);
    //改
    @Update("UPDATE USERINFO SET name=#{name},address=#{address} WHERE id=#{id}")
    Integer updateUserById(User user);
}
