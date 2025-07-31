package com.example.hello;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    
    @GetMapping("/")
    public String hello() {
        return "Hello World! -1156";
    }
    
    @GetMapping("/hello")
    public String helloMessage() {
        return "Привет из Spring Boot приложения!";
    }
}