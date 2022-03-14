package com.apurvtripathi.ekea.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.apurvtripathi.ekea.service.ProductService;

@Controller

public class homeController implements ErrorController{
	@Autowired
	private ProductService theProductService;
	
	@RequestMapping("/")
	public String getHomePage(Model theModel) {
		theModel.addAttribute("productList", theProductService.findAll());
		return "index";
	}
	@ConditionalOnMissingBean
	@RequestMapping("/error")
	public String error() {
		return "error";
	}
	
	@RequestMapping("/signup")
	public String getSignUpForm() {
		return "signupForm";
	}
	@RequestMapping("/login")
	public String getLogInForm() {
		return "loginForm";
	}
	@RequestMapping("/about")
	public String getAboutPage() {
		return "about";
	}
}


