package com.bank.virtualbank.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.bank.virtualbank.entities.Cuenta;
import com.bank.virtualbank.entities.User;
import com.bank.virtualbank.services.CuentaServices;
import com.bank.virtualbank.services.UserServices;

@RestController
public class CuentaController {

	@Autowired
	CuentaServices cS;

	@Autowired
	UserServices uS;

	public CuentaController(CuentaServices cS) {
		this.cS = cS;
	}

	@RequestMapping(value = "/cuenta/add", method = RequestMethod.POST, produces = "application/json")
	public Cuenta addCuenta(@RequestParam long userId) { // Este user sería el usuario en sesión
		if (uS.getUser(userId).isPresent()) {
			User u = uS.getUser(userId).get();
			Cuenta c = new Cuenta(0, u);
			cS.actualizarCuenta(c);
			return c;
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Element id not present");
		}

	}

	@RequestMapping(value = "/cuenta/ingreso", method = RequestMethod.PUT, produces = "application/json")
	public Cuenta ingresarSaldo(@RequestParam long id, @RequestParam long saldo) {

		if ((cS.getCuenta(id).isPresent())) {
			cS.meterDinero(cS.getCuenta(id).get(), saldo);
			return cS.getCuenta(id).get();
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Element id not present");
		}

	}

	@RequestMapping(value = "/cuenta/check", method = RequestMethod.GET, produces = "application/json")
	public Cuenta consultarSaldo(@RequestParam long id) {
		if (cS.getCuenta(id).isPresent()) {
			return cS.getCuenta(id).get();
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Element id not present");
		}

	}

}
