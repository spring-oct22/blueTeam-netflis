package com.gfttraining.security;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginLogoutController {
	
	@GetMapping("/login")
		String login () {
			return "login";
	}
	
	@GetMapping("/logout")
		String logout () {
			return "logout";
	}

}
