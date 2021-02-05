package com.bank.virtualbank.entities;



public class User {
	
	private String dni;
	private String nombre;
	private long idCliente;
	private Cuenta[] cuentas;

	public User(String dni, String nombre) {

		this.dni = dni;
		this.nombre = nombre;

	}

	public String getDni() {
		return dni;
	}

	public String getNombre() {
		return nombre;
	}

	public long getIdCliente() {
		return idCliente;
	}

	public Cuenta[] getCuentas() {
		return cuentas;
	}

}
