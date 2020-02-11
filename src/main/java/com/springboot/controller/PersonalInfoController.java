package com.springboot.controller;

import javax.persistence.NoResultException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.model.PersonalInfo;
import com.springboot.model.User;
import com.springboot.repository.UserRespository;
import com.springboot.services.PersonalInfoService;

@RestController
@RequestMapping("personalDetail")
public class PersonalInfoController {

	@Autowired
	private PersonalInfoService personalService;
	@Autowired
	private UserRespository userRepository;

	@PostMapping("/addPeronalInfo/{userId}")
	public PersonalInfo addPersonalDetails(@PathVariable("userId") Long Id, @RequestBody PersonalInfo person) {
		User user = userRepository.findById(Id).get();
		if (user == null) {
			System.out.println("throw exception");
			throw new NoResultException("User Not Found!");
		}
		if (user != null && user.getIsAdmin()) {
			return personalService.addPersonalDetails(person, Id, user);
		} else {
			return null;
		}
	}
}
