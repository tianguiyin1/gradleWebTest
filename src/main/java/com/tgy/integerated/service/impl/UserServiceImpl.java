package com.tgy.integerated.service.impl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.tgy.integerated.bean.User;
import com.tgy.integerated.mapper.UserMapper;
import com.tgy.integerated.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;
	
	@Override
	public User getUserById(int userId) {
		User user = userMapper.findById(userId);
		return user;
	}

	@Override
	public List<User> getAllUser() {
		return userMapper.findAll();
	}

	@Override
	public boolean insertUser(User user) {
		userMapper.save(user);
		return true;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public boolean updateUser(User user) {
		userMapper.update(user);
		System.out.println(1/0);
		user.setName(user.getName() + "changed");
		userMapper.update(user);
		return true;
	}
	
	@Override
	public boolean aupdateUser(User user) {
		userMapper.update(user);
		System.out.println(1/0);
		user.setName(user.getName() + "changed");
		userMapper.update(user);
		return true;
	}

	@Override
	public boolean deleteUserById(int id) {
		userMapper.delete(id);
		return true;
	}

}
