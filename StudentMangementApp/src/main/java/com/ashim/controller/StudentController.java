package com.ashim.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ashim.bo.Student;
import com.ashim.service.StudentServiceImpl;

@RestController
@RequestMapping("/students")
public class StudentController {
	
	private final StudentServiceImpl service; 
	
	@Autowired
	public StudentController(StudentServiceImpl service) {
		this.service = service;
	}
	
	@PostMapping()
	public Student addStudent(@RequestBody Student newStudent) {
		return service.createStudent(newStudent);
	}
	
	@GetMapping("/{id}")
	public Student getStudentById(@PathVariable Long id) {
		return service.getStudentById(id);
	}
	
	@GetMapping()
	public List<Student> getAllStudents() {
		System.out.println("Get request called..");
		List<Student> list = service.getAllStudents();
		return list;
	}
	
	@PutMapping("/{id}")
	public Student updateStudent(@PathVariable Long id, @RequestBody Student updatedStudent) {
		if(!id.equals(updatedStudent.getId())) {
			throw new IllegalArgumentException("Path variable ID and request body ID do not match");
		}
		return service.updateStudent(updatedStudent);
	}
	
	@DeleteMapping("/{id}")
	public String deleteStudentById(@PathVariable Long id) {
	    return service.deleteStudentById(id);
	}
}
