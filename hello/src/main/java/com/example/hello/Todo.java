package com.example.hello;

import java.time.LocalDateTime;

/**
 * Simple Todo Record - заменяет Lombok @Data
 * Автоматически создает: конструктор, геттеры, equals, hashCode, toString
 */
public record Todo(
        Long id,
        String title,
        String description,
        boolean completed,
        LocalDateTime createdAt
) {
    
    // Статический метод-фабрика
    public static Todo create(String title, String description) {
        return new Todo(null, title, description, false, LocalDateTime.now());
    }
    
    // Метод для изменения статуса
    public Todo markCompleted() {
        return new Todo(id, title, description, true, createdAt);
    }
    
    // Валидация в compact constructor
    public Todo {
        if (title == null || title.trim().isEmpty()) {
            throw new IllegalArgumentException("Title cannot be empty");
        }
    }
}