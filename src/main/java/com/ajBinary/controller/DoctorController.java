package com.ajBinary.controller;



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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.ajBinary.entity.Doctor;
import com.ajBinary.service.DoctorService;
import com.ajBinary.service.DoctorServiceImpl;

@ResponseBody
@RestController
@RequestMapping("api/v1/doctor")
@CrossOrigin("http://localhost:3000")
public class DoctorController {
	
	@Autowired
	private  DoctorServiceImpl doctorService;
	
	@GetMapping("all")
	public ResponseEntity<List<Doctor>> getDoctor(){
		return new ResponseEntity<>(doctorService.getDoctors(), HttpStatus.OK);
	}
	@GetMapping("/{id}")
	public ResponseEntity<Doctor> getDoctor(@PathVariable Long id){
		return new ResponseEntity<>(doctorService.getDoctor(id), HttpStatus.OK);
	}
	@PostMapping
	public ResponseEntity<Doctor> addDoctor(@RequestBody Doctor doctor){
		return  new ResponseEntity<>(doctorService.saveDoctor(doctor),HttpStatus.CREATED);

	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Doctor> updateDoctor(@PathVariable Long id, @RequestBody Doctor doctor){
	      return new ResponseEntity<>(doctorService.updateDoctor(id,doctor),HttpStatus.ACCEPTED);     
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Doctor> deleteDoctor(@PathVariable Long id){
        doctorService.deleteDoctor(id);
        return new ResponseEntity<>(HttpStatus.OK);
	}

	}
	
