package com.jacaranda.estanco.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity(name="pedido")
public class Pedido {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@ManyToOne
	@JoinColumn(name="username", insertable=true, updatable=true)
	private User usuario;
	private LocalDate date;
	private Double iva;
	@OneToMany
	@JoinColumn (name="id_order", insertable=true, updatable=true)
	private List<Purchase> listCompra;
	
	public Pedido() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Pedido(Double iva, User username, LocalDate date) {
		super();
		this.iva=iva;
		this.usuario = username;
		this.date = date;
		this.listCompra=new ArrayList<>();
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public User getUsername() {
		return usuario;
	}


	public void setUsername(User username) {
		this.usuario = username;
	}


	public LocalDate getDate() {
		return date;
	}


	public void setDate(LocalDate date) {
		this.date = date;
	}


	public Double getIva() {
		return iva;
	}


	@Override
	public int hashCode() {
		return Objects.hash(id);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pedido other = (Pedido) obj;
		return Objects.equals(id, other.id);
	}


	@Override
	public String toString() {
		return "Order [id=" + id + ", username=" + usuario.getName() + ", date=" + date + ", iva=" + iva + "]";
	}
	
	
	
	

}
