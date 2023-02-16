package com.jacaranda.estanco.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.jacaranda.estanco.model.Category;
import com.jacaranda.estanco.model.Tabaco;
import com.jacaranda.estanco.repository.CategoryRepository;
import com.jacaranda.estanco.repository.MaterialRepository;

@Service
public class MaterialService {

	@Autowired
	private MaterialRepository repository;
	
	@Autowired
	private CategoryService repositoryCategory;

	public Page<Tabaco> findAll(int pageNum, int pageSize, String sortField, String stringFind, int  idCategoria){
		Pageable pageable = PageRequest.of(pageNum -1, pageSize,Sort.by(sortField).ascending());
		if(idCategoria!=0) {
			Category c=repositoryCategory.getCategory(idCategoria);
			return repository.findByCategory(c, pageable);
		}
		if(stringFind==null) {
			return repository.findAll(pageable);
		}else {
			return repository.findByNameLike('%'+stringFind+'%', pageable);
		}
		}
	
	public List<Tabaco> getItems() {
		return repository.findAll();
	}

	public Tabaco getItem(Integer id) {
		return repository.findById(id).orElse(null);
	}
	
	

	public Tabaco addItem(Tabaco material) {
		
		if (material.getName() != null && material.getDescription() != null
				&& material.getStock() > 0 && material.getPrice() > 0) {
			return repository.save(material);
		}
		return material;
	}

	public boolean deleteItem(Tabaco material) {
		boolean deleted = false;

		if (this.getItem(material.getId()) != null) {
			repository.delete(material);
			deleted = true;
		}

		return deleted;
	}

	public Tabaco updateItem(Tabaco material) {
		Tabaco movies = null;
		if (material.getId() != null && material.getName() != null && material.getDescription() != null
				&& material.getStock() > 0 && material.getCategory() != null && material.getPrice() > 0) {
			movies = this.getItem(material.getId());

			movies.setName(material.getName());
			;
			movies.setDescription(material.getDescription());
			movies.setPrice(material.getPrice());
			movies.setStock(material.getStock());
			movies.setCategory(material.getCategory());
			;

			movies = repository.save(movies);
		}

		return movies;
	}

}
