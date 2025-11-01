package com.example.SkillEnroll.model;

import java.time.LocalDate;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(
	    name= "course_registry",
	    uniqueConstraints = @UniqueConstraint(columnNames = {"name", "email_id"})
	)
public class CourseRegistry {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String name;
	private String emailId;
	private String courseName;
	private LocalDate enrollDate;
	
	public LocalDate getEnrollDate() {
		return enrollDate;
	}
	public void setEnrollDate(LocalDate enrollDate) {
		this.enrollDate = enrollDate;
	}
	
	public CourseRegistry(String name, String emailId, String courseName) {
		this.name = name;
		this.emailId = emailId;
		this.courseName = courseName;
		this.enrollDate=LocalDate.now();
	}
	public CourseRegistry(String name, String emailId, String courseName, LocalDate enrollDate) {
		this.name = name;
		this.emailId = emailId;
		this.courseName = courseName;
		this.enrollDate=LocalDate.now();
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public CourseRegistry() {
		
	}
	
}
