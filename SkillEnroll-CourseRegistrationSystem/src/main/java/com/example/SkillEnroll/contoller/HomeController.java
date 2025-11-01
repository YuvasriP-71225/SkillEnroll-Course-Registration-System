package com.example.SkillEnroll.contoller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/skillenroll")
public class HomeController {

    @GetMapping("")
    public String homePage() {
        return "index";
    }

    @GetMapping("/register")
    public String registerPage() {
        return "register";
    }

    @GetMapping("/availcourses")
    public String availableCoursesPage() {
        return "availcourses"; 
    }

    @GetMapping("/enrolled")
    public String enrolledPage() {
        return "enrolled";
    }
    
    

}
