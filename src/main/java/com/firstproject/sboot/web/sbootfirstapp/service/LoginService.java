package com.firstproject.sboot.web.sbootfirstapp.service;

import org.springframework.stereotype.Component;

@Component
public class LoginService {
	public boolean validateUser(String name, String password) {
		return name.equalsIgnoreCase("iamavn") && password.equalsIgnoreCase("abcdef");
	}

}
