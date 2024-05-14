package com.ajBinary.repo;


import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import com.ajBinary.entity.Doctor;


public interface DoctorRepo extends CrudRepository<Doctor,Long> {

	Optional<Doctor> findDoctorByName(String Name);

	
	

	
}
