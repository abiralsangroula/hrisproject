package com.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.model.User;
import com.springboot.repository.UserRespository;
import com.springboot.services.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	@Autowired
	private UserService userService;
	
	@Autowired
	private UserRespository userRepo;
	

	@Autowired
	BCryptPasswordEncoder passEncode;

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
		user.setPassword(passEncode.encode(user.getPassword().toString()));
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
	
	@GetMapping("/delFlgUser/{id}")
	public void deleteUser(@PathVariable("id") Long id) {
		userRepo.deleteByUserId(id);
	}
}
