package com.jacaranda.student.servicies;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.jacaranda.student.model.Student;
import com.jacaranda.student.repositorie.StudentRepositorie;

public class StudentService {
	
	@Autowired
	StudentRepositorie repositorio;
	
	
	public Student getStudent(long id) {
		return repositorio.findById(id).orElse(null);
	}
	
	public List<Student> getStudents(){
		return repositorio.findAll();
	}
	
	public Student add(Student s) {
		return repositorio.save(s);
	}
	
	public void delete(Student s) {
		repositorio.delete(s);
	}
	
	public Student update(Student s) {
		if (getStudent(s.getId())!=null) {
			return repositorio.save(s);
		}else {
			return null;
		}
	}

}
