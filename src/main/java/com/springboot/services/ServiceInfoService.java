package com.springboot.services;

import javax.persistence.NoResultException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.model.PersonalInfo;
import com.springboot.model.ServiceInfo;
import com.springboot.model.User;
import com.springboot.repository.PersonalInfoRepository;
import com.springboot.repository.ServiceInfoRepository;
import com.springboot.repository.UserRespository;

@Service
public class ServiceInfoService {

	@Autowired
	private ServiceInfoRepository serviceRepository;

	@Autowired
	private PersonalInfoRepository personalRepo;

	@Autowired
	private UserRespository userRepo;

	public ServiceInfo addServiceInfo(ServiceInfo service, Long id, PersonalInfo person) {
		ServiceInfo serviceInfo = new ServiceInfo();
		serviceInfo = service;
		serviceInfo.setPersonalInfoId(person);
		return serviceRepository.save(serviceInfo);
	}

}
