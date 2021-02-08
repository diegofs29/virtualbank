package com.bank.virtualbank.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.virtualbank.entities.Cuenta;
import com.bank.virtualbank.repositories.CuentaRepository;

@Service
public class CuentaServices {

	@Autowired
	CuentaRepository cR;

	public void crearCuenta(Cuenta cuenta) {
		cR.save(cuenta);

	}

	public void meterDinero(Cuenta cuenta, double saldoAMeter) {
		cuenta.setSaldo(cuenta.getSaldo() + saldoAMeter);
		cR.save(cuenta);

	}

	public Optional<Cuenta> getCuenta(long id) {

		return cR.findById(id);

	}

}
