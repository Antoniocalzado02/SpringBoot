package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.Student;
import com.example.demo.services.StudentService;

@Controller
public class ControlStudent {
	
	@Autowired
	StudentService repositorio;
	
	@GetMapping("/listStudents")
	public String listStudent(Model model) {
		model.addAttribute("lista", repositorio.getStudents());
		return "listStudents";
	}
	
	@GetMapping("/addStudent")
	public String addStudent(Model model) {
		Student stu=new Student ();
		model.addAttribute("student", stu);
		
		return "addStudent";
		
	}
	
	@PostMapping("/addStudent/submit")
	public String addSubmitStudent(@ModelAttribute("student") Student nuevo) {
		repositorio.add(nuevo);
		return "redirect:/listStudents";
	}
	
	@GetMapping("/deleteStudent")
	public String deleteStudent(Model model, @RequestParam(name="name", required=false, defaultValue="") String name,
			@RequestParam(name="surname", required=false, defaultValue="") String surname) {
		Student stu=repositorio.get(name, surname);
		model.addAttribute("student", stu);
		
		return "deleteStudent";
		
	}
	
	@GetMapping("/deleteStudent/submit")
	public String deleteSubmitStudent(@ModelAttribute("student") Student nuevo) {
		repositorio.remove(nuevo);
		return "redirect:/listStudents";
	}
	
	

}
