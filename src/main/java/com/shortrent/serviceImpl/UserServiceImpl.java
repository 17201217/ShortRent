package com.shortrent.serviceImpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.shortrent.dao.UserDao;
import com.shortrent.pojo.User;
import com.shortrent.service.UserService;

@Service
public class UserServiceImpl implements UserService{
    
	@Autowired  
    private UserDao userDao;

	@Override
    public User findUserById(String userId) {
		return userDao.findUserById(userId);
	}

	@Override
	public User findUserByPhone(String user_tel) {
		return userDao.findUserByPhone(user_tel);
	}

	@Override
	public User findUserByEmail(String user_email) {
		return userDao.findUserByEmail(user_email);
	}

	public int add(User user) {
		return userDao.add(user);
	}

	public int update(User user) {
		return userDao.update(user);
	}

	public List<User> getAllUsers(int start, int end) {
		return userDao.getAllUsers(start, end);
	}

	public int getCount() {
		return userDao.getCount();
	}

	public int updpassword(String user_id) {
		return userDao.updpassword(user_id);
	}

	public int block(String user_id) {
		return userDao.block(user_id);
	}

	public int unblock(String user_id) {
		return userDao.unblock(user_id);
	}

	@Override
	public List<User> findUserByIdlike(String str) {
		// TODO Auto-generated method stub
		return userDao.findUserByIdlike(str);
	}

}