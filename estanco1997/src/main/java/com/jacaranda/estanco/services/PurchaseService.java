package com.jacaranda.estanco.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jacaranda.estanco.model.Purchase;
import com.jacaranda.estanco.repository.PurchaseRepository;

@Service
public class PurchaseService {

	@Autowired
	private PurchaseRepository repository;
	
	public Purchase addPurchase(Purchase p) {
		return repository.save(p);
	}
}
