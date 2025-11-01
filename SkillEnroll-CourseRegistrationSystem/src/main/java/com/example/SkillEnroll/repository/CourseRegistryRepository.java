package com.example.SkillEnroll.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.SkillEnroll.model.CourseRegistry;

@Repository
public interface CourseRegistryRepository extends JpaRepository<CourseRegistry,Integer>{
List<CourseRegistry> findAllByNameAndEmailId(String name, String emailId);

List<CourseRegistry> findByEmailId(String emailId);
	
}
