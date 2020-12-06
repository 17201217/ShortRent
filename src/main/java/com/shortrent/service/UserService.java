package com.shortrent.service;

import java.util.List;

import com.shortrent.pojo.User;

public interface UserService {
    public User findUserById(String userId);

    public User findUserByPhone(String user_tel);

    public User findUserByEmail(String user_email);
    
    public List<User> getAllUsers(int start, int end);
    
    int getCount();
    
    public int add(User user);
    
    public int update(User user);
    
    public int updpassword(String user_id);
    
    public int block(String user_id);
    
    public int unblock(String user_id);
    
    //根据id查user（like）
    public List<User> findUserByIdlike(String str);
}
