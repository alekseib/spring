package com.example.springhelloworld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @GetMapping("/")
    public String helloWorld() {
        return "Hello World from Spring Boot 3.4.0 with Java 21 and Gradle! 🚀";
    }

    @GetMapping("/hello")
    public String hello() {
        return "Hello, Spring Boot with Gradle!";
    }

    @GetMapping("/info")
    public String info() {
        return "This is a Spring Boot 3.4.0 application running on Java " + 
               System.getProperty("java.version") + " with Gradle build tool";
    }
}