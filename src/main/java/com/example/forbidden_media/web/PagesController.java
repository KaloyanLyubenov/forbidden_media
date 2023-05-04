package com.example.forbidden_media.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class PagesController {

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/contact")
    public String contact(){
        return "contact";
    }

    @GetMapping("/resume")
    public String resume(){
        return "resume";
    }
    @GetMapping("/projects")
    public String projects(){
        return "projects";
    }



}
