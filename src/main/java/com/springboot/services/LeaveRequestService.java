package com.springboot.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.repository.LeaveRepository;
import com.springboot.repository.UserRespository;

@Service
public class LeaveRequestService {
	
	@Autowired
	private LeaveRepository leaveRepository;
	
	@Autowired
	private UserRespository userRepository;
	
	public void addLeaveRequest() {
		
	}

}
