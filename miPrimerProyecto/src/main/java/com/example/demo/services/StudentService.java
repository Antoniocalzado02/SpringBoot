package com.example.demo.services;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;



import org.springframework.stereotype.Service;

import com.example.demo.model.Student;

@Service
public class StudentService {
	
	private List<Student> lista;
	
	public StudentService() {
		lista= new ArrayList<Student>();
		lista.add(new Student("Antonio","Calzado",20));
		lista.add(new Student("Javi","Robert",20));
		lista.add(new Student("Sergio","Maroto",20));
		lista.add(new Student("Alberto","Adame",20));
		lista.add(new Student("Vicente","Fuerte",20));
	}

	public List<Student> getStudents() {
		return lista;
	}

	public boolean add(Student arg0) {
		return lista.add(arg0);
	}

	public boolean remove(Student arg0) {
		return lista.remove(arg0);
	}
	
	public Student get(String nombre, String surname) {
		Boolean resultado=false;
		Student resultadoStudent = null;
		
		Iterator<Student> iterator= (Iterator) this.lista.iterator();
		while(iterator.hasNext() && !resultado) {
			resultadoStudent=iterator.next();
			if(resultadoStudent.getName().equals(nombre) && resultadoStudent.getSurname().equals(surname)) {
				resultadoStudent.setAge(20);
				resultado=true;
			}
		}
		
		
		return resultadoStudent;
	}

	
	
	

}
