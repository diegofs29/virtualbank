package com.bank.virtualbank.entities;


public class Cuenta {
	private double saldo;
	private String numeroCuenta;
	private long idCuenta;
	private User user;

	public Cuenta(double saldo, String numeroCuenta, User user) {
		this.saldo = saldo;
		this.numeroCuenta = numeroCuenta;
		this.user = user;

	}

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

}
