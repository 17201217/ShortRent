package com.shortrent.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.shortrent.pojo.User;

@Mapper
public interface UserDao {

    //根据id查user
    public User findUserById(String userId);

    //根据手机查user
    public User findUserByPhone(String user_tel);

    //根据邮箱查user
    public User findUserByEmail(String user_email);
    
    //根据id查user（like）
    public List<User> findUserByIdlike(String str);
    
    //得到所有用户
    List<User> getAllUsers(@Param("start") int start, @Param("end")int end);
    
    //得到数量
    int getCount();
    
    //添加
    public int add(User user);
    
    //更新信息
    public int update(User user);

    //改密码
    public int updpassword(@Param("user_id") String user_id);
    
    //封禁
    public int block(@Param("user_id") String user_id);
    
    //解封
    public int unblock(@Param("user_id") String user_id);
    

    
} 
