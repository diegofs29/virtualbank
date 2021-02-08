package com.bank.virtualbank.services;

import java.util.Optional;

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
	
	public void darAltaUsuario(User user) {
		User u = uR.save(user);
	}
	
	public Iterable<User> getUsers() {
		return uR.findAll();
	}
	
	public User getUser(long id) {
		return uR.findById(id).get();
	}
	
	public void actualizarUsuario(User user) {
		uR.save(user);
	}
}
