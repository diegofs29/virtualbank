package com.bank.virtualbank.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.bank.virtualbank.util.View;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Table(name = "cuentas")
public class Cuenta {
	@JsonView(View.Internal.class)	
	private double saldo;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@JsonView(View.Public.class)
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

	public long getIdCuenta() {
		return idCuenta;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public User getUser() {
		return user;
	}

	public boolean retirarSaldo(double saldo) {
		if (saldo <= this.saldo) {
			this.saldo -= saldo;
			return true;
		}
		return false;
	}

}
