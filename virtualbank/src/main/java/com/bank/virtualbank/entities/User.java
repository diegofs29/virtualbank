package com.bank.virtualbank.entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private String dni;
	private String name;
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private Set<Cuenta> cuentas;

	public User(String dni, String name) {

		this.dni = dni;
		this.name = name;

	}

	public User() {
	}

	public String getDni() {
		return dni;
	}

	public String getNombre() {
		return name;
	}

	public long getId() {
		return id;
	}

	public Set<Cuenta> getCuentas() {
		return cuentas;
	}

	@Override
	public String toString() {
		return "User [dni=" + dni + ", name=" + name + "]";
	}

}
