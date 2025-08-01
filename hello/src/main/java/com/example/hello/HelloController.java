package com.example.hello;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;

@RestController
public class HelloController {
    @GetMapping("/")
    public String hello() {
        return "Hello World! -1156";
    }
    @GetMapping("/hello")
    public String helloMessage() {
        return "Hi!";
    }

    @PostMapping("/hello")
    public ResponseEntity<String> helloMessagePost(@RequestBody TestMessage testMessage)
    {
        try {
            System.out.println("Received message: " + testMessage.message());
            return ResponseEntity.ok("Привет из Spring Boot приложения! Сообщение: " + testMessage.message());
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body("Ошибка: " + e.getMessage());
        }
    }
}