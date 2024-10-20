package com.mycode.springboot.demosecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

	@GetMapping("/showMyLoginPage")
	public String showMyLoginPage() {
		
		return "fancy-login";
	}
	
	
	//add request mapping for /leaders
	@GetMapping("/leaders")
	public String showLeaders() {
		
		return "leaders";
	}
	
	@GetMapping("/systems")
	public String showAdmin() {
		
		return "admins";
	}
	
	@GetMapping("/access-denied")
	public String accessDenied() {
		
	return "accessdeniedpage";
	}
}
