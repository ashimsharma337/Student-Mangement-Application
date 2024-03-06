package com.ashim.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ashim.bo.Student;

public interface IStudentRepository extends JpaRepository<Student, Long>{

}
