package com.bank.virtualbank.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bank.virtualbank.services.UserServices;

@RestController
public class UserController {
	
	@Autowired
	private UserServices uS;
	
	public UserController(UserServices uS) {
		this.uS = uS;
	}
	
	@RequestMapping(value = "/user/add", method = RequestMethod.POST)
	public String addUser() {
		return "Added (not really)";
	}

}
