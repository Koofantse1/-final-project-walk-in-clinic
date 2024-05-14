package com.ajBinary.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import com.ajBinary.entity.Doctor;
import com.ajBinary.repo.DoctorRepo;
import com.fasterxml.jackson.databind.util.BeanUtil;

@Service
public class DoctorServiceImpl implements DoctorService {
	
	@Autowired
	private DoctorRepo doctorRepo;
	
	@Override
	public Doctor getDoctor(Long id) {
		return doctorRepo.findById(id)
				.orElseThrow(()-> new ResourceNotFoundException("Author not found with id: " + id));
	}
	
	@Override
	public Doctor getDoctor(String Name) {
		return doctorRepo.findDoctorByName(Name)
				.orElseThrow(()-> new ResourceNotFoundException("Author not found with name: " + Name));
	}
	
	@Override
	public List<Doctor> getDoctors() {
		return (List<Doctor>) doctorRepo.findAll();
	
	}
	
	@Override
	public void deleteDoctor(Long id) {
		doctorRepo.deleteById(id);
	}
	@Override
	public Doctor saveDoctor(Doctor doctor) {
		return doctorRepo.save(doctor);
	}
	@Override
	public Doctor updateDoctor(Long id, Doctor doctor) {
		Optional<Doctor> optionalDoctor = doctorRepo.findById(id);
		if (optionalDoctor.isPresent()) {
			optionalDoctor.get().setDoctorById(id);
			optionalDoctor.get().setName(doctor.getName());
			optionalDoctor.get().setNPI(doctor.getNPI());
			
			
			return doctorRepo.save(optionalDoctor.get());
		}else throw new ResourceNotFoundException("Doctor not found with id: " + id);
	}
}
