package com.jacaranda.estanco.model;

import java.io.Serializable;
import java.util.Objects;

public class Purchase_Join implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Integer idOrder;
	private Integer materialCode;
	
	
	public Purchase_Join() {
		super();
		// TODO Auto-generated constructor stub
	}


//	public Purchase_Join(Integer idOrder, Integer materialCode) {
//		super();
//		this.idOrder = idOrder;
//		this.materialCode = materialCode;
//	}


	public Integer getIdOrder() {
		return idOrder;
	}


	public void setIdOrder(Integer idOrder) {
		this.idOrder = idOrder;
	}


	public Integer getMaterialCode() {
		return materialCode;
	}


	public void setMaterialCode(Integer materialCode) {
		this.materialCode = materialCode;
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
		Purchase_Join other = (Purchase_Join) obj;
		return Objects.equals(idOrder, other.idOrder) && Objects.equals(materialCode, other.materialCode);
	}


	@Override
	public String toString() {
		return "Purchase_Join [idOrder=" + idOrder + ", materialCode=" + materialCode + "]";
	}
	
	
	
	

}
