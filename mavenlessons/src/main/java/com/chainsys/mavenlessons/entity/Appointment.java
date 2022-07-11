package com.chainsys.mavenlessons.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Table(name = "Appointments")
public class Appointment {
	@Id
	@Column(name = "APP_ID ")
	private int id;
	@Column(name = "APP_DATE ")
	private Date appDate;
	@Column(name = "DOC_ID ")
	private int doctorId;
	@Column(name = "PATIENT_NAME")
	private String patientname;
	@Column(name = "FEES_COLLECTED")
	private float feescollected;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "DOC_ID",nullable = false, insertable = false ,updatable = false)
	@JsonIgnore
	private Doctor doctor;
	public Doctor getDoctor() {
		return doctor;
	}
	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getAppDate() {
		return appDate;
	}
	public void setAppDate(Date appDate) {
		this.appDate = appDate;
	}
	public int getDoctorid() {
		return doctorId;
	}
	public void setDoctorid(int doctorid) {
		doctorId = doctorid;
	}
	public String getPatientname() {
		return patientname;
	}
	public void setPatientname(String patientname) {
		this.patientname = patientname;
	}
	public float getFeescollected() {
		return feescollected;
	}
	public void setFeescollected(float feescollected) {
		this.feescollected = feescollected;
	}
	@Override
	public String toString() {
		return String.format("%d,%s,%d,%s,%d",id, appDate,doctorId,patientname,feescollected );
	}

}
