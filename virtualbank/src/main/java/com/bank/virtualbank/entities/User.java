package com.bank.virtualbank.entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private String dni;
	private String name;

	private boolean blocked;

	@JsonManagedReference
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private Set<Cuenta> cuentas;

	public User(String dni, String name) {

		this.dni = dni;
		this.name = name;
		this.blocked = false;
	}

	public User() {
	}

	public String getDni() {
		return dni;
	}

	public String getNombre() {
		return name;
	}

	public boolean isBlocked() {
		return blocked;
	}

	public long getId() {
		return id;
	}

	public Set<Cuenta> getCuentas() {
		return cuentas;
	}
	
	public void bloquear() {
		blocked = true;
	}
	
	public void desbloquear() {
		blocked = false;
	}

	@Override
	public String toString() {
		return "User [dni=" + dni + ", name=" + name + "]";
	}

}
