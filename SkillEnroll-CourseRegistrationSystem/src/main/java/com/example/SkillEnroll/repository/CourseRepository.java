package com.example.SkillEnroll.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.SkillEnroll.model.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course,String>{

}
