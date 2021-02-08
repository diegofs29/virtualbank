package com.bank.virtualbank.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bank.virtualbank.entities.Cuenta;
import com.bank.virtualbank.services.CuentaServices;

@RestController
public class CuentaController {

	@Autowired
	private CuentaServices cS;

	public CuentaController(CuentaServices cS) {
		this.cS = cS;
	}

	@RequestMapping(value = "/cuenta/retirar", method = RequestMethod.PUT, produces = "application/json")
	public Cuenta retirarDinero(@RequestParam double cantidad, @RequestParam long idCuenta) {
		Cuenta c = cS.getCuenta(idCuenta);
		cS.actualizarCuenta(c);
		return c;
	}

}
