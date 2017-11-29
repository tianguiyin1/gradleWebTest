package com.tgy.integerated.service;

import java.util.List;

import com.tgy.integerated.bean.User;

public interface UserService {
	User getUserById(int userId);
	List<User> getAllUser();
	boolean insertUser(User user);
	boolean updateUser(User user);
	boolean aupdateUser(User user);
	boolean deleteUserById(int id);
}
