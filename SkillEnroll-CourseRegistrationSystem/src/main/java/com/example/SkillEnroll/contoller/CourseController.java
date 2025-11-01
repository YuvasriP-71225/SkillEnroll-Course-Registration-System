package com.example.SkillEnroll.contoller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.SkillEnroll.model.Course;
import com.example.SkillEnroll.model.CourseRegistry;
import com.example.SkillEnroll.service.CourseService;


@RestController
@RequestMapping("/skillenroll/api/courses")

public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping("")
    public List<Course> availableCourses() {
        return courseService.availableCourses();
    }

    @GetMapping("/enrolled")
    public List<CourseRegistry> enrolledStudents() {
        return courseService.enrolledStudents();
    }

    @PostMapping("/register")
    public String enrollCourse(@RequestParam("name") String name,
                               @RequestParam("emailId") String emailId,
                               @RequestParam ("courseName")String courseName
                               ) {
    	
    	return courseService.enrollCourse(name, emailId, courseName);
    }

    @DeleteMapping("/unenroll")
    public ResponseEntity<String> unenrollStudent(@RequestParam String name, @RequestParam String emailId){
    	String result=courseService.unenrollStudent(name, emailId);
    	return ResponseEntity.ok(result);
    }
    
}
