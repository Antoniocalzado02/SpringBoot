package com.jacaranda.estanco.services;


import java.util.ArrayList;
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

@Service
public class CategoryService {
	
		
		@Autowired
		private CategoryRepository repository;

		public Page<Category> findAll(int pageNum, int pageSize, String sortField, String stringFind){
			Pageable pageable = PageRequest.of(pageNum -1, pageSize,Sort.by(sortField).ascending());
			if(stringFind==null || stringFind=="") {
				return repository.findAll(pageable);
			}else {
				return repository.findByNameLike('%'+stringFind+'%', pageable);
			}
			}
		
		public List<Category> getCategories() {
			return repository.findAll();
		}
		
		public Category getCategory(Integer id) {
			return repository.findById(id).orElse(null);
		}

		public Category addCategory(Category category) {
			Category saved = null;
			
			List<Tabaco> listMaterial= new ArrayList<>();
			
			if ( category.getName()!=null && category.getDescription() != null) {
				category.setMaterialList(listMaterial);
				saved = repository.save(category);
			}
			
			return saved;
		}
		
		public boolean deleteCategory(Category category) {
			boolean deleted = false;
			
			if(this.getCategory(category.getId()) != null) {
				
				repository.delete(category);
				deleted = true;
			}
			
			return deleted;
		}
		
		public Category updateCategory(Category categoryMod) {
			Category saved = null;
			Category cat = this.getCategory(categoryMod.getId());
			categoryMod.setMaterialList(cat.getMaterialList());
			
			if(categoryMod.getId() != null && categoryMod.getMaterialList() != null && categoryMod.getDescription() != null) {
				
				cat.setName(categoryMod.getName());
				cat.setDescription(categoryMod.getDescription());;
				saved = repository.save(cat);
			}
			
			return saved;
		}
		
		
	


}
