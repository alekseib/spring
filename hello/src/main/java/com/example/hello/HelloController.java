package com.example.hello;

import jakarta.websocket.server.PathParam;
import org.springframework.web.bind.annotation.*;
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

    @PostMapping("/hello/{aaa}")
    public ResponseEntity<String> helloMessagePost(@RequestBody TestMessage testMessage, @PathVariable String aaa)
    {
        try {
            System.out.println("Received message: " + testMessage.message());
            return ResponseEntity.ok("Hi," + testMessage.message() + " " + aaa);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body("Ошибка: " + e.getMessage());
        }
    }
}