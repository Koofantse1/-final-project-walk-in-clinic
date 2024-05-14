package com.ajBinary.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import com.ajBinary.entity.Doctor;
import com.ajBinary.entity.Patient;
import com.ajBinary.repo.PatientRepo;

@Service
public class PatientServiceImpl implements PatientService{
	
	@Autowired
	private PatientRepo patientRepo;
	
	@Override
	public List<Patient> getPatients() {
		return (List<Patient>) patientRepo.findAll();

	}
	
	@Override
	public Patient getPatientById(Long id) {
		Optional<Patient> patient = patientRepo.findById(id);
		if (patient.isPresent()) {
			return patient.get();
		}else {
			throw new ResourceNotFoundException("Oops! Patient with " + id + " does not exist in our database");
			
		}
		
		
		}
	@Override
	public Patient savePatient(Patient patient) {
		return patientRepo.save(patient);
}
	@Override
	public Patient updatePatient(Long id, Patient patient) {
		Optional<Patient> optionalPatient = patientRepo.findById(id);
		if (optionalPatient.isPresent()) {
			optionalPatient.get().setFirstName(patient.getFirstName());
			//optionalPatient.get().setPatient(patient.getLastName());
			//optionalPatient.get().setPatient(patient.getAsgnProvider());
			
			
			patientRepo.save(optionalPatient.get());
			
			return optionalPatient.get();
		}else {
			throw new ResourceNotFoundException("Patient with " + id + " does not exist");
		}
	}
		@Override
		public void deletePatient(Long id) {
			patientRepo.deleteById(id);
}

}

