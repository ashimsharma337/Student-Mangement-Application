package com.ashim.service;

import java.util.List;

import com.ashim.bo.Student;

public interface IStudentService {

	Student createStudent(Student newStudent);
	Student getStudentById(Long id);
	List<Student> getAllStudents();
	Student updateStudent(Student updatedStudent);
	String deleteStudentById(Long id);
}
