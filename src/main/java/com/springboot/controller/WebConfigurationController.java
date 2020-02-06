package com.springboot.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class WebConfigurationController {

	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String initialPage(HttpServletResponse response) {
		System.out.println("Reach heheheheheh");
		response.setHeader("Content-Type","text/html");
		return "index";
	}

}
