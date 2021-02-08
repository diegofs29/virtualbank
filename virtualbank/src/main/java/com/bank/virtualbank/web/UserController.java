package com.bank.virtualbank.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bank.virtualbank.entities.User;
import com.bank.virtualbank.services.UserServices;

@RestController
public class UserController {

	@Autowired
	private UserServices uS;

	public UserController(UserServices uS) {
		this.uS = uS;
	}

	@RequestMapping(value = "/user/add", method = RequestMethod.POST)
	public String addUser(@RequestParam String dni, @RequestParam String name) {
		User u = new User(dni, name);
		uS.darAltaUsuario(u);
		return "Added user with DNI = " + u.getDni() + " and name = " + u.getNombre();
	}
	
	@RequestMapping(value = "/user/get", method = RequestMethod.GET)
	public String getUsers() {
		StringBuilder sb = new StringBuilder();
		Iterable<User> i = uS.getUsers();
		i.forEach(user -> sb.append(user.toString() + "\n"));
		return sb.toString();
	}
	
	@RequestMapping(value = "/user/block", method = RequestMethod.PUT)
	public String blockUser(@RequestParam long id) {
		User u = uS.getUser(id);
		if(u.isBlocked())
			u.desbloquear();
		else
			u.bloquear();
		uS.actualizarUsuario(u);
		return u.isBlocked() ? "Usuario bloqueado" : "Usuario desbloqueado";
	}

}
