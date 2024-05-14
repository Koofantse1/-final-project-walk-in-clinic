package com.ajBinary.service;

import java.util.List;

import com.ajBinary.entity.Patient;


public interface PatientService {
	
	// Get all Patients
		List<Patient> getPatients();
		// Find Patient by id
		Patient getPatientById(Long id);
		// Add new Patient
		Patient savePatient(Patient patient);
		// Update Patient
		Patient updatePatient(Long id, Patient patient);
		// Delete Patient
		void deletePatient(Long id);
	
}
