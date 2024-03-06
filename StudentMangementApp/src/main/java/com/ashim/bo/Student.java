package com.ashim.bo;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="student")
public class Student {
	
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private Long id;

@Column(name="first_name")
private String firstName;

@Column(name="last_name")
private String lastName;

@Column(name="date_of_birth")
private LocalDate dateOfBirth;

@Column(name="gender")
private String gender;

@Column(name="email_address")
private String emailAddress;

@Column(name="phone_number")
private String phoneNumber;

@Column(name="address")
private String address;

}
