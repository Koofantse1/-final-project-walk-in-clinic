package com.ajBinary.repo;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.ajBinary.entity.Patient;

public interface PatientRepo extends CrudRepository<Patient,Long> {
	Optional<Patient> findPatientBymemberId(Long memberID);
	
	

}
