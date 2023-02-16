package com.jacaranda.estanco.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.jacaranda.estanco.errorPage.ApiError;
import com.jacaranda.estanco.exception.ElementNotFoundException;
import com.jacaranda.estanco.model.Category;
import com.jacaranda.estanco.model.Tabaco;
import com.jacaranda.estanco.model.User;
import com.jacaranda.estanco.services.CategoryService;
import com.jacaranda.estanco.services.UserService;

@RestController
public class CategoryController {
	
	@Autowired
	CategoryService service;
	
	@GetMapping("/categories")
	public List<Category> getCategories(){
		
		return service.getCategories();
	}
	
	@GetMapping("/categories/{id}")
	public ResponseEntity<?> addget(@PathVariable int id) {
		Category result=service.getCategory(id);
		if(result==null) {
			throw new ElementNotFoundException(id);
		}else {
			return ResponseEntity.ok(result);
		}
		}
		
		@ExceptionHandler(ElementNotFoundException.class)
		public ResponseEntity<ApiError> handleElementNotFoundException(ElementNotFoundException e){
			ApiError apiError = new ApiError(HttpStatus.NOT_FOUND, e.getMessage());
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(apiError);
		} 

		@PutMapping("/categories/{id}")
		public ResponseEntity<?> edit(@RequestBody Category elemento,
				@PathVariable Integer id) {
			if(service.getCategory(id)!=null) {
				elemento.setId(id);
				service.addCategory(elemento);
				return ResponseEntity.ok(elemento);
			}else {
				return ResponseEntity.notFound().build();
			}
		}
		
		@PostMapping("/categories")
		public ResponseEntity<?> add(@RequestBody Category elemento) {
			if(service.getCategory(elemento.getId())==null) {
				service.addCategory(elemento);
				return ResponseEntity.ok(elemento);
			}else {
				return ResponseEntity.notFound().build();
			}
		}
		
		@DeleteMapping("/categories/{id}")
		public ResponseEntity<?>  delete(@PathVariable Integer id) {
			if(service.getCategory(id)!=null) {
				Category e = service.getCategory(id);
				service.deleteCategory(e);
				return ResponseEntity.ok("Element deleted");
			}else {
				return ResponseEntity.notFound().build();
			}
		}
	

}
