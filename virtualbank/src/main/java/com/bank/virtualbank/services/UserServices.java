package com.bank.virtualbank.services;

import com.bank.virtualbank.entities.Cuenta;
import com.bank.virtualbank.entities.User;

public class UserServices {

	public void vincularCuenta(Cuenta cuenta, User user) {
		user.getCuentas();
	}
}
