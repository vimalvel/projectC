package com.chainsys.mavenlessons.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

import com.chainsys.mavenlessons.entity.Appointment;
import com.chainsys.mavenlessons.entity.Doctor;
import com.chainsys.mavenlessons.repository.AppointmentRepository;

@RestController
public class AppointmentControl {
	@Autowired
	private AppointmentRepository repo;

	// @Bean
//	    public void createrepo(DoctorRepositories repo) {
//	        this.repo=repo;
//	    }
	@GetMapping(value = "/fetchdoctorbyappointment")
	public String getDoctorByAppId(int id) {
		Appointment app=repo.findById(id);
		Doctor doc = app.getDoctor();
		return doc.toString();
	}
		@GetMapping	(value="/fetchappointment")
	public Appointment getappById(int id) {
		return repo.findById(id);
	}
		@GetMapping(value = "/fetchallappointments")
		public List<Appointment> getAllapp(){
			return repo.findAll();
		}

	@GetMapping("/getappointment")
	public Appointment getApt(int id) {
		return repo.findById(id);
	}

	@PostMapping(value = "/addappointment", consumes = "application/json")
	// we need to give from where to read data from the HTTP request and also the
	// content type ("application/json")
	public RedirectView addapt(@RequestBody Appointment apt) {

		repo.save(apt);
		return new RedirectView ("/getallappointments");
	}

	@DeleteMapping("/deleteappoinment")
	public RedirectView deleteapt(int id) {
		repo.deleteById(id);
		return new RedirectView ("/getallappointments");
	}

	@GetMapping("/getallapp")
	public List<Appointment> getAllApt() {
		return repo.findAll();
	}

	@GetMapping("/getallbyid")
	public List<Appointment> getallByDoctorId(int drId) {
		return repo.findByDoctorId(drId);
	}

}
