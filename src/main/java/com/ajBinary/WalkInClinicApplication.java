package com.ajBinary;

import java.util.Arrays;
import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ajBinary.entity.Doctor;
import com.ajBinary.entity.Patient;
import com.ajBinary.entity.User;
import com.ajBinary.repo.DoctorRepo;
import com.ajBinary.repo.PatientRepo;
import com.ajBinary.repo.UserRepo;

import ch.qos.logback.classic.Logger;

@SpringBootApplication
public class WalkInClinicApplication {//implements CommandLineRunner{
	
	@Autowired
	 private DoctorRepo doctorRepo;
	
	@Autowired
	private PatientRepo patientRepo;
	@Autowired
	private UserRepo useRepo;
	
	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(WalkInClinicApplication.class);
		
	public static void main(String[] args) {
		SpringApplication.run(WalkInClinicApplication.class, args);
		logger.info("Application Started");
		
		
	}
	
	
	public void run(String... args)throws Exception{
		
		Doctor doctor1 = new Doctor("Dr Caroline", "Gynochologi");
		Doctor doctor2 = new Doctor( "Dr Scarlet", "Therapist");
		Doctor doctor3 = new Doctor("Dr Shay Cantly", "Gynochologist");
		doctorRepo.saveAll(Arrays.asList(doctor1, doctor2, doctor3));
		List<Patient> patients = Arrays.asList(
				new Patient("Seth", "Kofi", "Addae", "UHC", "cash", "Dr Shaheda", 34),
				new Patient("Kenken", "K", "Addae", "TRICARE", "cash", "Dr Scarlet", 34),
				new Patient("AchoAcho", "B", "Addae", "BCBS", "cash", "Dr Patel", 7),
				new Patient("Mikumiku", "Sansan", "Toyota", "UHCVA", "cash", "Dr Morimotor", 34)
				);
		        patientRepo.saveAll(patients);
				
		 
		doctorRepo.findAll().forEach(doctor -> logger.info(doctor.getNPI() +" "+doctor.getName()));
		        
		// Username: user, password: userPass
				useRepo.save(new User("user", "$2y$10$dc3e3saiBRuwAmihOB0cWe8cI./MVgKIrdq9uCukCnRXYoNgYR1e6", "USER"));
				// Username: admin, password: adminPass
				useRepo.save(new User("admin", "$2y$10$VKlPOmlBxacyOtoGuASJuu6F0E4Gf/VfiWsVZSHlr3xHzjn9DQ68W", "ADMIN"));
			}
		
	}


