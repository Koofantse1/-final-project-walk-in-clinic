package com.ajBinary.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Doctor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long NPI;
	@Column(nullable = false)
	private String name, speciality;
	
	public Doctor() {
		super();
	}
	public Doctor(String name, String speciality) {
		super();
	
		this.name = name;
		this.speciality = speciality;
	}
	public Long getNPI() {
		return NPI;
	}
	public void setNPI(Long nPI) {
		NPI = nPI;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSpeciality() {
		return speciality;
	}
	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}
	public void setDoctorById(Long id) {
		// TODO Auto-generated method stub
		
	}
	
	
	
}

	
	