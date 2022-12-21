package com.jacaranda.student.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jacaranda.student.model.Student;
import com.jacaranda.student.servicies.StudentService;



public class StudentController {
	
	public StudentController() {
		// TODO Auto-generated constructor stub
	}
	@Autowired
	StudentService repositorio;

	
	@GetMapping("/login")
	public String login(Model modelo) {
		
		return "login";
	}
	/**
	 * Metodo get que devuelve los estudiantes.
	 * @param modelo
	 * @return
	 */
	@GetMapping({"/","/listStudents"})
	public String listStudent(Model modelo) {
		
		modelo.addAttribute("lista", repositorio.getStudents());
		return "listStudents";
	}
	
	/**
	 * Método get que instancia un estudiante y lo mapea con una template, "addStudent.html"
	 * 
	 * @param modelo
	 * @return
	 */
	@GetMapping("AddStudent")
	public String listStudentAdd(Model modelo) {
		
		Student student= new Student();
		
		modelo.addAttribute("student", student );
		return "addStudent";
	}
	
	/**
	 * Recoje el objeto student que hemos instanciado antes y le hemos dado valores en la template
	 * llamamos al service y añadimos ese objeto a la lista. Por ultimo redirijimos a la lista Estudiantes
	 * @param student
	 * @return
	 */
	@PostMapping("/listStudents/AddSubmit")
	public String listStudentsAddMethod (@Validated @ModelAttribute("student") Student student, BindingResult binding) {
		if(binding.hasErrors()) {
			return "addStudent";
		}else {
			repositorio.add(student);
			
			return "redirect:/listStudents";		
		}
	}
	
	
	@GetMapping("/delStudent")
	public String delStudent(Model model, @RequestParam(name="id", required=false, defaultValue="") long id) {
		
		
		Student estudiante = repositorio.getStudent(id);
		model.addAttribute("student", estudiante);
		return "delStudent";
	}
	
	@PostMapping("/delStudent/delSubmit")
	public String listStudentsdelMethod ( @ModelAttribute("student") Student student) {
		
		repositorio.delete(student);
			
		return "redirect:/listStudents";
	}
	
	@GetMapping("/editStudent")
	public String editStudent(Model model, @RequestParam(name="id", required=true, defaultValue="")long id) {
		
		Student estudiante = repositorio.getStudent(id);
		model.addAttribute("student", estudiante);
		
		return "editStudent";
	}
	
	@PostMapping("/editStudent/Submit")
	public String listStudentseditMethod ( @ModelAttribute("student") Student student) {
		
		Student sb=new Student(student.getId(), student.getName(), student.getSurname(),student.getAge());
		
		repositorio.update(sb);
			
		return "redirect:/listStudents";
	}
	

}
