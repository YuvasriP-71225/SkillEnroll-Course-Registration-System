package com.example.SkillEnroll.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.SkillEnroll.model.Course;
import com.example.SkillEnroll.model.CourseRegistry;
import com.example.SkillEnroll.repository.CourseRegistryRepository;
import com.example.SkillEnroll.repository.CourseRepository;

@Service
public class CourseService {

	@Autowired
	CourseRepository repo;
	
	@Autowired
	CourseRegistryRepository registryRepo;
	
	public List<Course> availableCourses() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	public List<CourseRegistry> enrolledStudents() {
		// TODO Auto-generated method stub
		return registryRepo.findAll();
	}

	
	public String unenrollStudent(String name, String emailId) {
	    List<CourseRegistry> students = registryRepo.findAllByNameAndEmailId(name, emailId);

	    if (!students.isEmpty()) {
	        registryRepo.deleteAll(students);
	        return "Unenrolled successfully for " + name;
	    } else {
	        return "No enrollment found for given name and email.";
	    }
	}

	public String enrollCourse(String name, String emailId, String courseName) {
		// TODO Auto-generated method stub
		 List<CourseRegistry> existingEnrollments = registryRepo.findByEmailId(emailId);
		 if (!existingEnrollments.isEmpty()) {
		        CourseRegistry existing = existingEnrollments.get(0);

		        // If trying to enroll in a different course
		        if (!existing.getCourseName().equalsIgnoreCase(courseName)) {
		            return "already_enrolled_in_" + existing.getCourseName();
		        } 
		        // If same course again
		        else {
		            return "already_enrolled_same";
		        }
		    }


		CourseRegistry courseRegistry=new CourseRegistry(name, emailId, courseName);
		
		registryRepo.save(courseRegistry);
		return "success";
	}
	}
