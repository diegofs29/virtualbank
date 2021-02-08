package com.bank.virtualbank.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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

	@RequestMapping(value = "/cuenta/add", method = RequestMethod.POST)
	public String addCuenta(@RequestParam long userId) { // Este user sería el usuario en sesión
		if (uS.getUser(userId).isPresent()) {
			User u = uS.getUser(userId).get();
			Cuenta c = new Cuenta(0, u);
			cS.crearCuenta(c);
			return "Cuenta creada correctamente";
		} else {
			return "Usuario no encontrado";
		}

	}

	@RequestMapping(value = "/cuenta/ingreso", method = RequestMethod.PUT)
	public String ingresarSaldo(@RequestParam long id, @RequestParam long saldo) {

		if ((cS.getCuenta(id).isPresent())) {
			cS.meterDinero(cS.getCuenta(id).get(), saldo);
			return "Ingreso con éxito";
		} else {
			return "Error: Cuenta no existente";
		}

	}

	@RequestMapping(value = "/cuenta/check", method = RequestMethod.GET)
	public String consultarSaldo(@RequestParam long id) {
		if (cS.getCuenta(id).isPresent()) {
			return "" + cS.getCuenta(id).get().getSaldo();
		} else {
			return "Error: Cuenta no existente";
		}

	}

}
