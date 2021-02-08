package com.bank.virtualbank.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bank.virtualbank.entities.User;
import com.bank.virtualbank.services.UserServices;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.node.ObjectNode;

@RestController
public class UserController {

	@Autowired
	private UserServices uS;

	public UserController(UserServices uS) {
		this.uS = uS;
	}

	@RequestMapping(value = "/user/add", method = RequestMethod.POST, produces = "application/json")
	public User addUser(@RequestParam String dni, @RequestParam String name) {
		User u = new User(dni, name);
		uS.darAltaUsuario(u);
		return u;
	}
	
	@RequestMapping(value = "/user/get", method = RequestMethod.GET, produces = "application/json")
	public List<User> getUsers() {
		List<User> list = new ArrayList<User>();
		Iterable<User> i = uS.getUsers();
		i.forEach(user -> list.add(user));
		return list;
	}
	
	@RequestMapping(value = "/user/block", method = RequestMethod.PUT, produces = "application/json")
	public User blockUser(@RequestParam long id) {
		User u = uS.getUser(id);
		if(u.isBlocked())
			u.desbloquear();
		else
			u.bloquear();
		uS.actualizarUsuario(u);
		return u;
	}

}
