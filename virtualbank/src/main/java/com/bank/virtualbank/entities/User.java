package com.bank.virtualbank.entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.bank.virtualbank.util.View;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@JsonView(View.Public.class)
	private String dni;
	@JsonView(View.Public.class)
	private String name;

	@JsonView(View.Public.class)
	private boolean blocked;

	@JsonManagedReference
	@JsonView(View.Public.class)
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
