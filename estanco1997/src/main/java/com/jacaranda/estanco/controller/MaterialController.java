package com.jacaranda.estanco.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jacaranda.estanco.model.Tabaco;
import com.jacaranda.estanco.model.User;
import com.jacaranda.estanco.services.CategoryService;
import com.jacaranda.estanco.services.MaterialService;
import com.jacaranda.estanco.services.UserService;

@RestController
public class MaterialController {

//	private static final String REDIRECT_ITEM = "redirect:/material/list";
//
//	@Autowired
//	private MaterialService service;
//
//	@Autowired
//	private CategoryService categoryService;
//	
//	@Autowired
//	UserService repository;
//
//	@GetMapping("material/add")
//	public String addItem(Model model) {
//
//		model.addAttribute("categories", categoryService.getCategories());
//		model.addAttribute("material", new Tabaco());
//
//		return "addMaterial";
//	}
//
//	@PostMapping("material/add/submit")
//	public String addItemSubmit(@ModelAttribute Tabaco material) {
//
//		service.addItem(material);
//
//		return REDIRECT_ITEM;
//	}
//
//	@GetMapping("/material/delete")
//	public String deleteItem(@RequestParam Integer id, Model model) {
//
//		model.addAttribute("material", service.getItem(id));
//
//		return "deleteMaterial";
//	}
//
//	@PostMapping("/material/delete/submit")
//	public String deleteItemSubmit(@ModelAttribute Tabaco material) {
//
//		service.deleteItem(material);
//
//		return REDIRECT_ITEM;
//	}
//
//	@GetMapping("/material/update")
//	public String updateItem(@RequestParam Integer id, Model model) {
//
//		model.addAttribute("categories", categoryService.getCategories());
//		model.addAttribute("material", service.getItem(id));
//
//		return "updateMaterial";
//	}
//
//	@PostMapping("/material/update/submit")
//	public String updateItemSubmit(@ModelAttribute Tabaco material) {
//
//		service.updateItem(material);
//
//		return REDIRECT_ITEM;
//	}
//
//	
//	
//	@GetMapping({"material/list"})
//	public String getElements(Model model,@RequestParam("pageNumber")
//	Optional<Integer> pageNumber,
//	@RequestParam("sizeNumber") Optional<Integer> sizeNumber,
//	@RequestParam("sortField") Optional<String> sortField,
//	@RequestParam("stringFind")Optional<String> stringFind,
//	@RequestParam("idCategoria")Optional<Integer> idCategoria){
//	Page<Tabaco> page = service.findAll(pageNumber.orElse(1),
//	sizeNumber.orElse(10),sortField.orElse("id"),stringFind.orElse(null),idCategoria.orElse((int)0));
//	String nombre=SecurityContextHolder.getContext().getAuthentication().getName();
//	 User u=repository.(nombre);
//	 model.addAttribute("u", u);
//	model.addAttribute("currentPage",pageNumber.orElse(1));
//	model.addAttribute("totalPages",page.getTotalPages());
//	model.addAttribute("totalItems",page.getTotalElements());
//	model.addAttribute("sortField", sortField.orElse("id"));
//	model.addAttribute("stringFind",stringFind.orElse(""));
//	model.addAttribute("materials", page.getContent());
//	model.addAttribute("idCategoria",idCategoria.orElse((int)0));
//	
//	return "materialList";
//	}

}
