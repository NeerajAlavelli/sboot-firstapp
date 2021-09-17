package com.firstproject.sboot.web.sbootfirstapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.firstproject.sboot.web.sbootfirstapp.service.LoginService;

@Controller
@SessionAttributes("name")
public class LoginController {
	
	@Autowired
	LoginService service;
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String showLoginPage(ModelMap model) {
		//model.put("name", name);
		return "login";
	}
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String showWelcomePage(ModelMap model, @RequestParam String name, @RequestParam String password) {
		boolean validateUser = service.validateUser(name, password);
		if(!validateUser) {
			model.put("message", "Access Denied, Try Again");
			return "login";
		}
		model.put("name", name);
		model.put("password", password);
		return "welcome";
	}

}
