package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ControladorPrincipal {

	
	@GetMapping("/")
	public String principal() {
		return "index";
	}
	
	@GetMapping("/bienvenido")
	public String principal(Model model) {
		model.addAttribute("mensaje","Hola a todos");
		return "index";
	}
	
}
