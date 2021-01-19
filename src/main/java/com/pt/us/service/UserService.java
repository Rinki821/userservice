package com.pt.us.service;

import java.util.List;

import com.pt.us.entity.User;

public interface UserService {
	User saveUser(User u);
	User findById(long userId);
	String deleteUser(long userId);
	User updateUser(User u);
	List<User> getAllUser();
	

}
