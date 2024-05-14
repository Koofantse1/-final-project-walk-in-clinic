package com.ajBinary.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ajBinary.entity.Patient;
import com.ajBinary.service.PatientServiceImpl;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/v1/patient")
@CrossOrigin("http://localhost:3000")
public class PatientController {
	
	@Autowired
	private PatientServiceImpl patientService;
	
	@GetMapping("all")
	public ResponseEntity<List<Patient>> getPatient(){
		return new ResponseEntity<>(patientService.getPatients(), HttpStatus.OK);
	
	}
	@GetMapping("/{id}")
	public ResponseEntity<Patient> getPatient(@PathVariable Long id){
		return new ResponseEntity<>(patientService.getPatientById(id), HttpStatus.OK);
	
	}
	@PostMapping
	public ResponseEntity<Patient> addPatient(@RequestBody Patient patient, HttpServletRequest http) throws IOException{
		
		System.out.println(patient);
		return  new ResponseEntity<>(patientService.savePatient(patient),HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Patient> updatePatient(@PathVariable Long id, @RequestBody Patient patient){
	      return new ResponseEntity<>(patientService.updatePatient(id,patient),HttpStatus.ACCEPTED);
	                  
}
	@DeleteMapping("/{id}")
	public ResponseEntity<Patient> deletePatient(@PathVariable Long id){
        patientService.deletePatient(id);
        return new ResponseEntity<>(HttpStatus.OK);
	
	}
	
}
