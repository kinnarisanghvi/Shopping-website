package com.me.Pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class Users {

	@Id
	@Column(name = "UserName", length = 20, nullable = false)
	private String username;
	
	@Column(name = "Password", length = 20, nullable = false)
	private String password;
	
	@Column(name = "FirstName", length = 20, nullable = false)
	private String firstName;
	
	@Column(name = "LastName", length = 20, nullable = false)
	private String lastName;
	
	 @Column(name = "Role", length = 20, nullable = false)
	private String role;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}	
	
	
}
