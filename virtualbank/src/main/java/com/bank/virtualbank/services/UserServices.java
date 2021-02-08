package com.bank.virtualbank.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.virtualbank.entities.User;
import com.bank.virtualbank.repositories.UsersRepository;

@Service
public class UserServices {
	@Autowired
	private UsersRepository uR;

	public Optional<User> getUser(long id) {
		return uR.findById(id);
	}

}
