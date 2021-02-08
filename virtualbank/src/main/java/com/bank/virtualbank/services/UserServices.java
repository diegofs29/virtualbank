package com.bank.virtualbank.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.virtualbank.repositories.UsersRepository;

@Service
public class UserServices {
	@Autowired
	private UsersRepository uR;

	
}
