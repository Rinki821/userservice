package com.pt.us.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pt.us.entity.User;
import com.pt.us.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	UserRepository userRepository;

	@Override
	public User saveUser(User u) {
		u = userRepository.save(u);
		return u;
	}

	@Override
	public User findById(long userId) {
		return userRepository.findById(userId).get();
	}

	@Override
	public String deleteUser(long userId) {
		User u = userRepository.findById(userId).get();
		userRepository.delete(u);
		return " user is deleted ";
	}

	@Override
	public User updateUser(User u) {
		User existingUser = this.findById(u.getId());
		System.out.println("existingUser = " + existingUser);
		if (existingUser == null) {
			System.out.println("existingUser is null");
			return null;
		} else {
			existingUser.setName(u.getName());
			existingUser.setPannum(u.getPannum());
			userRepository.save(existingUser);
			System.out.println("After saving ");
			return existingUser;
		}

	}

	@Override
	public List<User> getAllUser() {

		return userRepository.findAll();
	}

}
