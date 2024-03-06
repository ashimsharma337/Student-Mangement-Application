package com.ashim.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ashim.bo.Student;
import com.ashim.dao.IStudentRepository;
import com.ashim.exceptions.ResourceNotFoundException;

@Service
public class StudentServiceImpl implements IStudentService {
	
	private final IStudentRepository repo;
	
	@Autowired
	public StudentServiceImpl(IStudentRepository repo) { 
		this.repo = repo;
	}
    
	@Override
	public Student createStudent(Student newStudent) {
		return repo.save(newStudent);
	}

	@Override
	public Student getStudentById(Long id) {
		Optional<Student> student = repo.findById(id);
		if(student.isPresent()) {
			return student.get();
		} else {
			return student.orElseThrow(() -> new ResourceNotFoundException("Student with id "+id+" not found!"));
		}
	}

	@Override
	public List<Student> getAllStudents() {
		return repo.findAll();
	}
	
	@Override
	public Student updateStudent(Student updatedStudent) {
		Long StudentId = updatedStudent.getId();
		
		Optional<Student> optional = repo.findById(StudentId);
		if(optional.isPresent()) {
			Student existingStudent = optional.get();
			
			existingStudent.setFirstName(updatedStudent.getFirstName());
			existingStudent.setLastName(updatedStudent.getLastName());
			existingStudent.setDateOfBirth(updatedStudent.getDateOfBirth());
			existingStudent.setGender(updatedStudent.getGender());
			existingStudent.setEmailAddress(updatedStudent.getEmailAddress());
			existingStudent.setPhoneNumber(updatedStudent.getPhoneNumber());
			existingStudent.setAddress(updatedStudent.getAddress());

			return repo.save(existingStudent);
		} else {
			throw new ResourceNotFoundException("Student with ID "+StudentId+" not found!");
		}
	}


	@Override
	public String deleteStudentById(Long id) {
		Optional<Student> student = repo.findById(id);
		if(student.isPresent()) {
			Student studentToBedeleted = student.get();
			repo.delete(studentToBedeleted);
			return "Student with ID "+id+" deleted successfully!";
		} else {
			throw new ResourceNotFoundException("Student with ID "+id+" not found!");
		}
	}

}
