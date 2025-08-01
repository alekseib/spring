package com.example.hello;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TestController {

    @GetMapping("/test")
    public String test() {
        return "Test successful!";
    }

    @GetMapping("/todo")
    public Todo getTodo() {
        // Создаем Todo с помощью Record
        return Todo.create("Изучить Java 21 Records", "Понять как заменить Lombok");
    }
    
    @GetMapping("/todos")
    public List<Todo> getTodos() {
        var todo1 = Todo.create("Выучить Spring Boot", "Основы фреймворка");
        var todo2 = Todo.create("Настроить DevTools", "Для быстрой разработки");
        var todo3 = todo1.markCompleted(); // Immutable update
        
        return List.of(todo1, todo2, todo3);
    }
}
