package com.example.hello;

/**
 * Record для тестовых сообщений
 */
public record TestMessage(String message) {
    
    // Валидация в compact constructor
    public TestMessage {
        if (message == null || message.trim().isEmpty()) {
            throw new IllegalArgumentException("Message cannot be empty");
        }
    }
    
    // Статический метод-фабрика
    public static TestMessage of(String message) {
        return new TestMessage(message);
    }
}