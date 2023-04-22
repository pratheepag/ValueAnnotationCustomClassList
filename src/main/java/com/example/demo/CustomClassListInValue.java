package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Todos;

@RestController
public class CustomClassListInValue {

	@Value("${student.list}")
	private Todos students;
	
	@RequestMapping("student/all")
	public Todos getStudents() {
		System.out.println("Student List"+students);
		return students;
	}
	

}
