package com.jacaranda.estanco.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jacaranda.estanco.model.Tabaco;
import com.jacaranda.estanco.model.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Integer>{

}
