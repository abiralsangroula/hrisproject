package com.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.model.User;
import com.springboot.services.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	@Autowired
	private UserService userService;

	@GetMapping("/userList")
	public List<User> getAllUsers() {
		return userService.findAllUsers();
	}

	@GetMapping("/{id}")
	public User findByUserId(@PathVariable("id") Long id) {
		return userService.findById(id);
	}
	
	@PostMapping("/createUser")
	public User createUser(@RequestBody User user) {
		return userService.createUser(user);
	}

	@PostMapping("/updateUser/{id}")
	public User updateUser(@PathVariable("id") Long id, @RequestBody User user) {
		return userService.updateUser(id, user);
	}
	
	@PostMapping("/deleteUser/{id}")
	public User deleteUser(@PathVariable("id") Long id, @RequestBody User user) {
		return userService.deleteUser(id, user);
	}
}
