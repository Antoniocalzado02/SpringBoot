package com.jacaranda.primerSpring.controller;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jacaranda.primerSpring.model.Calculator;

@Controller
public class ControllerMain {

//	@GetMapping("/")
//	public String principal() {
//		return "index";
//	}
	
	@GetMapping({"/bienvenido", "/"})
	public String welcome(Model model, @RequestParam(name="mensaje", required=false, defaultValue="Yo") String nombre,
			@RequestParam( required=false, defaultValue="Nieve") String apellido) {
		model.addAttribute("mensaje", nombre);
		model.addAttribute("apellido",apellido);
		return "index";
	}

	
//	@GetMapping({"/bienvenido2", "/"})
//	public String welcome2(Model model, @RequestParam(name="mensaje") Optional<String>  nombre,
//			@RequestParam( required=false, defaultValue="Nieve") String apellido) {
//		model.addAttribute("mensaje", nombre);
//		model.addAttribute("apellido",apellido);
//		return "index";
//	}
	

	@GetMapping({"/suma"})
	public String suma(Model model) {
		Calculator calc = new Calculator();
		
		model.addAttribute("calc", calc);
			
		return "calculator";
	}
	
	@PostMapping({"/sumaSubmit"})
	public String sumaSubmit(Model model, @ModelAttribute("calc") Calculator calc) {
		
		
		model.addAttribute("resultado", calc.Operaciones());
			
		return "resultado";
	}
}

