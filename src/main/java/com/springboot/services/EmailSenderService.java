package com.springboot.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailSenderService {

	private JavaMailSender javaMailSender;
	
	@Autowired
	private EmailSenderService (JavaMailSender javaMailSender) {
		this.javaMailSender=javaMailSender;
	}
	
	public void sendMail(SimpleMailMessage email) {
		javaMailSender.send(email);
	}
}
