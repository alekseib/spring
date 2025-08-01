package com.example.hello;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Глобальный обработчик ошибок для всего приложения
 */
@ControllerAdvice
public class GlobalExceptionHandler {
    
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleIllegalArgumentException(IllegalArgumentException e) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body("Ошибка валидации: " + e.getMessage());
    }
    
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<String> handleHttpMessageNotReadableException(HttpMessageNotReadableException e) {
        // Проверяем если это ошибка валидации в Record
        if (e.getCause() != null && e.getCause().getCause() instanceof IllegalArgumentException) {
            IllegalArgumentException cause = (IllegalArgumentException) e.getCause().getCause();
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("Ошибка валидации: " + cause.getMessage());
        }
        
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body("Ошибка чтения JSON: невалидный формат данных");
    }
}