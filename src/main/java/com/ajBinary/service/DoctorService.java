package com.ajBinary.service;

import java.util.List;

import com.ajBinary.entity.Doctor;


public interface DoctorService {
	Doctor getDoctor(Long id);
	Doctor getDoctor(String name);
	List<Doctor> getDoctors();
	void deleteDoctor(Long id);
	Doctor saveDoctor(Doctor doctor);
	Doctor updateDoctor(Long id, Doctor doctor);	

}
