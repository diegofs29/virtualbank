package com.bank.virtualbank.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.virtualbank.entities.Cuenta;
import com.bank.virtualbank.repositories.CuentaRepository;

@Service
public class CuentaServices {
	
	@Autowired
	private CuentaRepository cR;
	
	public Cuenta getCuenta(long id) {
		Optional<Cuenta> c = cR.findById(id);
		return c.isPresent() ? c.get() : null;
	}
	
	public void actualizarCuenta(Cuenta cuenta) {
		cR.save(cuenta);
	}

}
