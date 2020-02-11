package com.springboot.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.persistence.NoResultException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.springboot.model.User;
import com.springboot.repository.UserRespository;

@Service
public class UserService {
	@Autowired
	private UserRespository repository;
	

	public List<User> findAllUsers() {
		return repository.findAll();
	}
	
	public User findById(Long id) {
		User user= repository.findById(id).get();
		if(user== null) {
			throw new NoResultException("User Not Found");
		}
		return user;
	}

	public User createUser(User user) {
		User createUser = new User();
		createUser= user;
		createUser.setCreatedDate(new Date());
		return repository.save(createUser);

	}

	public User updateUser(Long id, User user) {

		Optional<User> userFound = repository.findById(id);
		if (userFound.isPresent()) {
			User existingUser = userFound.get();
			existingUser= user;
			return repository.save(existingUser);
		}
		return user;
	}

	public User deleteUser(Long id, User user) {
		Optional<User> userFound = repository.findById(id);
		if(userFound.isPresent()) {
			User userExist= userFound.get();
			userExist=user;
			userExist.setDelFlg(true);
			userExist.setDelDate(new Date());
			return repository.save(userExist);
		}
		return user;
	}
	
}
