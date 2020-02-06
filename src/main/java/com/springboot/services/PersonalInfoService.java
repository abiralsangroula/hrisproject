package com.springboot.services;

import java.util.Date;
import java.util.Optional;

import javax.persistence.NoResultException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.model.PersonalInfo;
import com.springboot.model.User;
import com.springboot.repository.PersonalInfoRepository;
import com.springboot.repository.UserRespository;

@Service
public class PersonalInfoService {

	@Autowired
	private PersonalInfoRepository personalRepo;

	@Autowired
	private UserRespository userRespository;

	public PersonalInfo addPersonalDetails(PersonalInfo person, Long id, User user) {
		PersonalInfo addPersonal = new PersonalInfo();
		addPersonal = person;
		addPersonal.setDelFlg(false);
		addPersonal.setCreatedDate(new Date());
		addPersonal.setCreatedBy(user);
		return personalRepo.save(addPersonal);
	}
}