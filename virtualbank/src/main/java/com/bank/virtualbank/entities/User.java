package com.bank.virtualbank.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private String dni;
	private String nombre;

	private Cuenta[] cuentas;

	public User(String dni, String nombre) {

		this.dni = dni;
		this.nombre = nombre;

	}
	
	public User() {}

	public String getDni() {
		return dni;
	}

	public String getNombre() {
		return nombre;
	}

	public long getId() {
		return id;
	}

	public Cuenta[] getCuentas() {
		return cuentas;
	}

}
