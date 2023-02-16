package com.jacaranda.estanco.model;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity (name="purchase")
@IdClass(Purchase_Join.class)
public class Purchase {
	
	@Id
	@ManyToOne
	@JoinColumn(name="id_order", insertable=true, updatable=true)
	private Pedido idOrder;
	
	@Id
	@ManyToOne
	@JoinColumn(name="material_code", insertable=true, updatable=true)
	private Tabaco materialCode;
	
	private Integer quantity;
	
	
	public Purchase() {
		super();
		// TODO Auto-generated constructor stub
	}


	

	public Purchase(Pedido idOrder, Tabaco materialCode, Integer quantity) {
		super();
		this.idOrder = idOrder;
		this.materialCode = materialCode;
		this.quantity = quantity;
	}




	public Pedido getIdOrder() {
		return idOrder;
	}




	public void setIdOrder(Pedido idOrder) {
		this.idOrder = idOrder;
	}




	public Tabaco getMaterialCode() {
		return materialCode;
	}




	public void setMaterialCode(Tabaco materialCode) {
		this.materialCode = materialCode;
	}




	public Integer getQuantity() {
		return quantity;
	}


	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}


	@Override
	public int hashCode() {
		return Objects.hash(idOrder, materialCode);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Purchase other = (Purchase) obj;
		return Objects.equals(idOrder, other.idOrder) && Objects.equals(materialCode, other.materialCode);
	}


	@Override
	public String toString() {
		return "Purchase [idOrder=" + idOrder + ", materialCode=" + materialCode + ", quantity=" + quantity + "]";
	}
	
	
	
	
	
	

}
