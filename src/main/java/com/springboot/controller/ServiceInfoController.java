package com.springboot.controller;

import javax.persistence.NoResultException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.model.PersonalInfo;
import com.springboot.model.ServiceInfo;
import com.springboot.model.User;
import com.springboot.repository.PersonalInfoRepository;
import com.springboot.repository.UserRespository;
import com.springboot.services.ServiceInfoService;

@RestController
@RequestMapping("/serviceInfo")
public class ServiceInfoController {

	@Autowired
	private ServiceInfoService serviceInfoService;
	@Autowired
	private UserRespository userRepo;
	@Autowired
	private PersonalInfoRepository personalRepo;

	@PostMapping("/addServiceInfo/{id}")
	public ServiceInfo addServiceInfo(@PathVariable("id") Long Id, @RequestBody ServiceInfo service) {
		PersonalInfo person = personalRepo.findById(Id).get();
		if (person == null) {
			throw new NoResultException("Sorry, Cannot process any further.");
		}
		User user = userRepo.findById(person.getCreatedBy().getId()).get();
		if (user.getIsAdmin()) {
			return serviceInfoService.addServiceInfo(service, Id,person);
		} else {
			return null;
		}
	}
}
