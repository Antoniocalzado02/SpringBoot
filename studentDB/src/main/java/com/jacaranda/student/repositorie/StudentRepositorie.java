package com.jacaranda.student.repositorie;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jacaranda.student.model.Student;

public interface StudentRepositorie extends JpaRepository<Student, Long> {
	
	

}
