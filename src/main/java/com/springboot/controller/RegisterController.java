package com.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
//@RequestMapping("/register")
public class RegisterController {
	
	@GetMapping("/register")
	public ModelAndView registerUser(ModelAndView modelAndView) {
		System.out.println("register");
		modelAndView.setViewName("register");
		return modelAndView;
	}

}
