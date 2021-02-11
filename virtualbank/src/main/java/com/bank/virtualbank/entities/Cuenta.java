package com.bank.virtualbank.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.bank.virtualbank.util.View;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Table(name = "cuentas")
public class Cuenta {
	@JsonView(View.Internal.class)
	private double saldo;

	@JsonView(View.Public.class)
	private int puntos;

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

	public int getPuntos() {
		return puntos;
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

	public void addPuntos(double ingreso) {
		if (ingreso > 20) {
			if (ingreso > 40) {
				if (ingreso > 70) {
					puntos += 3;
					return;
				}
				puntos += 2;
				return;
			}
			puntos += 1;
			return;
		}
	}

}
