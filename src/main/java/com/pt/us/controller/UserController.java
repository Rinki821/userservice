package com.pt.us.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pt.us.entity.User;
import com.pt.us.service.UserService;

@RestController
public class UserController {
	@Autowired
	UserService userService;

	@PostMapping(value = "/user/save", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public User saveUser(@RequestBody User u) {
		u = userService.saveUser(u);
		return u;
	}

	@GetMapping(value = "/user/findById/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public User findById(@PathVariable long userId) {
		User u  = userService.findById(userId);
		System.out.println("###" + u);
		return u;

	}
	@DeleteMapping(value="/user/delete/{userId}")
	public String deleteUser(@PathVariable long userId) {
		
		String msg= userService.deleteUser(userId);
		return msg;
		
	}
	@PutMapping(value= "/user/updateUser",consumes = MediaType.APPLICATION_JSON_VALUE ,produces = MediaType.APPLICATION_JSON_VALUE)
	public User updateUser(@RequestBody User u ) {
		return userService.updateUser(u);
		
		
	}
	@GetMapping( value ="/user/all",produces = MediaType.APPLICATION_JSON_VALUE)
	public List<User> allUser() {
		return userService.getAllUser();
	}
}
