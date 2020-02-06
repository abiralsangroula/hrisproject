package com.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebConfigurationController {

	@GetMapping("/")
	public String initialPage() {
		System.out.println("Reach heheheheheh");
		return "index.html";
	}

}
