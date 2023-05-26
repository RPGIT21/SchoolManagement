package com.rp.management.model;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.ManyToAny;

@Entity
@Table(uniqueConstraints = @UniqueConstraint (columnNames = "email"))
public class User {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String email;
	private String passwor;
	
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(
			name = "users_roles",
					joinColumns = @JoinColumn(
				            name = "user_id", referencedColumnName = "id"),
					inverseJoinColumns = @JoinColumn(
						            name = "role_id", referencedColumnName = "id")
			)
	
	public Collection<Role> roles;

	public User(String name, String email, String passwor, Collection<Role> roles) {
		super();
		this.name = name;
		this.email = email;
		this.passwor = passwor;
		this.roles = roles;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPasswor() {
		return passwor;
	}

	public void setPasswor(String passwor) {
		this.passwor = passwor;
	}

	public Collection<Role> getRoles() {
		return roles;
	}

	public void setRoles(Collection<Role> roles) {
		this.roles = roles;
	}
	
	

}
