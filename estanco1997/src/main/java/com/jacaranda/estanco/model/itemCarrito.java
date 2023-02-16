package com.jacaranda.estanco.model;

import java.time.LocalDate;
import java.util.Objects;

public class itemCarrito {
	
	private Tabaco material;
	private int cantidad;
	
	public itemCarrito() {
		super();
		// TODO Auto-generated constructor stub
	}

	public itemCarrito(Tabaco material, int cantidad) {
		super();
		this.material = material;
		this.cantidad = cantidad;
	}

	public Tabaco getMaterial() {
		return material;
	}

	public void setMaterial(Tabaco material) {
		this.material = material;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cantidad, material);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		itemCarrito other = (itemCarrito) obj;
		return cantidad == other.cantidad && Objects.equals(material, other.material);
	}

	@Override
	public String toString() {
		return "itemCarrito [material=" + material + ", cantidad=" + cantidad + "]";
	}
	
	
	
	
	
	
	
	
	

}
