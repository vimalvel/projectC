package com.chainsys.mavenlessons.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.chainsys.mavenlessons.entity.Appointment;

public interface AppointmentRepository extends CrudRepository<Appointment, Integer> {
	Appointment findById(int id);
	
//	@Query(value="select a from Appointment a where a.doctorId=?1")
//	jpql --> java persistence query language
//	here a is an instance of Appointment Entity
//	List<Appointment> findAllByDoctorId(int dr_Id);
	List<Appointment> findByDoctorId(int drId);
	List<Appointment> findAll();
	Appointment save(Appointment apt);
	void deleteById(int id);
	
	

}
