package com.bank.virtualbank.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "cuentas")
public class Cuenta {
	private double saldo;
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long numeroCuenta;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idCuenta;
	@JsonBackReference
	@ManyToOne
	private User user;

	public Cuenta(double saldo, User user) {
		this.saldo = saldo;
		this.user = user;

	}

	public Cuenta() {
	}

	public double getSaldo() {
		return saldo;
	}

	public long getNumeroCuenta() {
		return numeroCuenta;
	}

	public long getIdCuenta() {
		return idCuenta;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public User getUser() {
		return user;
	}

}
