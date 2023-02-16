package com.jacaranda.estanco.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jacaranda.estanco.model.Tabaco;
import com.jacaranda.estanco.model.Purchase;
import com.jacaranda.estanco.model.Purchase_Join;

public interface PurchaseRepository extends JpaRepository<Purchase, Purchase_Join>{

}
