package com.jacaranda.primerSpring.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.jacaranda.primerSpring.model.Student;

@Service
public class StudentService {

	private List<Student> listStudent;
	
	public StudentService() {
		listStudent = new ArrayList<>();
		listStudent.add(new Student("Vicente", "Villarreal", 20));
		listStudent.add(new Student("Javier", "Villarreal", 20));
		listStudent.add(new Student("Sergio", "Romero", 20));
		listStudent.add(new Student("Pilar", "Guzman", 20));
	}

	public boolean addStudent(Student e) {
		return listStudent.add(e);
	}
	
	

	public boolean removeStudent(Student o) {
		return listStudent.remove(o);
	}

	public Student getStudent(String name, String surname) {
		Boolean encontrado= false;
		Student student = new Student();
		for(Student e : this.listStudent) {
		if (e.getName().equals(name) && e.getSurname().equals(surname)) {
				encontrado=true;
				student=e;
			}
		}
			
		return student;
	}

	
	public Student updateStudent(String name, String surname, int edad) {
		Boolean encontrado= false;
		Student student = new Student();
		for(Student e : this.listStudent) {
		if (e.getName().equals(name) && e.getSurname().equals(surname)) {
				encontrado=true;
				student=e;
				student.setAge(edad);
			}
		}
			
		return student;
	}

	public List<Student> getListStudent() {
		return listStudent;
	}

	public void setListStudent(List<Student> listStudent) {
		this.listStudent = listStudent;
	}
	
	
	

}
