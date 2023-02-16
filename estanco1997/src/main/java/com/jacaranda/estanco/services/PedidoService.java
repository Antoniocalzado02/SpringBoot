package com.jacaranda.estanco.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jacaranda.estanco.model.Pedido;
import com.jacaranda.estanco.repository.PedidoRepository;

@Service
public class PedidoService {
	
	@Autowired
	private PedidoRepository repositorio;
	
	public Pedido addPedido(Pedido p) {
		return repositorio.save(p);
	}

}
