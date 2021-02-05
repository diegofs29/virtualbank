package com.bank.virtualbank.services;

import java.util.Optional;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.virtualbank.entities.Cuenta;
import com.bank.virtualbank.entities.User;
import com.bank.virtualbank.repositories.UsersRepository;

@Service
public class UserServices {
	@Autowired
	private UsersRepository uR;

	public void vincularCuenta(Cuenta cuenta, User user) {
		Optional<User> u = uR.findById(user.getId());
	}
}
