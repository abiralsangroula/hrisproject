package com.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class WebConfigController {
	
	@RequestMapping(value="/index", method=RequestMethod.GET,produces = "text/html")
    public String home() {
		System.out.println("reachhh");
         return "index";
    }
}
