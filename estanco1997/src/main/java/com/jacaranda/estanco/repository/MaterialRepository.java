package com.jacaranda.estanco.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.jacaranda.estanco.model.Category;
import com.jacaranda.estanco.model.Tabaco;

public interface MaterialRepository extends JpaRepository<Tabaco, Integer> {
	
	public Page<Tabaco> findByNameLike(String keyword,Pageable pageable);
	
	public Page<Tabaco> findByCategory(Category keyword,Pageable pageable);

}
