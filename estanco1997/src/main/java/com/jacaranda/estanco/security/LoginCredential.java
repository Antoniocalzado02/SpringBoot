package com.jacaranda.estanco.security;

public class LoginCredential {
	private String name;
	private String password;
	
	public LoginCredential(String name, String password) {
		super();
		this.name = name;
		this.password = password;
	}

	public LoginCredential() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	

}
