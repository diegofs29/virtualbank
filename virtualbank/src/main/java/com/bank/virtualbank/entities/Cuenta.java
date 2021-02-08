package com.bank.virtualbank.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "cuentas")
public class Cuenta {
	private double saldo;
	private String numeroCuenta;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idCuenta;
	@ManyToOne
	private User user;

	public Cuenta(double saldo, String numeroCuenta, User user) {
		this.saldo = saldo;
		this.numeroCuenta = numeroCuenta;
		this.user = user;

	}
	
	public Cuenta() {}

	public double getSaldo() {
		return saldo;
	}

	public String getNumeroCuenta() {
		return numeroCuenta;
	}

	public long getIdCuenta() {
		return idCuenta;
	}

	public User getUser() {
		return user;
	}
	
	public boolean retirarSaldo(double saldo) {
		if(saldo <= this.saldo) {
			this.saldo -= saldo;
			return true;
		}
		return false;
	}

}
