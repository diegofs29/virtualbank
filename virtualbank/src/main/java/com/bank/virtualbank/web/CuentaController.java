package com.bank.virtualbank.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bank.virtualbank.services.CuentaServices;

@RestController
public class CuentaController {

	@Autowired
	CuentaServices cS;

	public CuentaController(CuentaServices cS) {
		this.cS = cS;
	}

	@RequestMapping(value = "/cuenta/add", method = RequestMethod.POST)
	public void addCuenta() {

	}

	@RequestMapping(value = "/cuenta/ingreso/{id}", method = RequestMethod.POST)
	public void ingresarSaldo(@PathVariable long id) {

	}

	@RequestMapping(value = "/cuenta/check/{id}", method = RequestMethod.GET)
	public void consultarSaldo(@PathVariable long id) {

	}

}
