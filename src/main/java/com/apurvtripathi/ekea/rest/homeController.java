package com.apurvtripathi.ekea.rest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class homeController {
	
	@RequestMapping("/")
	public String getHomeScreen() {
		return "index";
	}
	
	@RequestMapping("/signup")
	public String getSignUpForm() {
		return "signupForm";
	}
}


