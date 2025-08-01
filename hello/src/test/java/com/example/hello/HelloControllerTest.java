package com.example.hello;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;

/**
 * Юнит-тесты для HelloController
 * @WebMvcTest загружает только web-слой (контроллеры)
 */
@WebMvcTest(HelloController.class)
class HelloControllerTest {

    @Autowired
    private MockMvc mockMvc;
    
    @Autowired
    private ObjectMapper objectMapper;
    
    @Test
    void testHelloEndpoint() throws Exception {
        // Тестируем GET /
        mockMvc.perform(get("/"))
                .andDo(print()) // Печатает запрос/ответ в консоль
                .andExpect(status().isOk())
                .andExpect(content().string("Hello World! -1156"));
    }
    
    @Test
    void testHelloMessageEndpoint() throws Exception {
        // Тестируем GET /hello
        mockMvc.perform(get("/hello"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string("Привет из Spring Boot приложения!"))
                .andExpect(content().contentType("text/plain;charset=UTF-8"));
    }
    
    @Test
    void testHelloMessagePost_ValidMessage() throws Exception {
        // Тестируем POST /hello с валидным сообщением
        TestMessage testMessage = TestMessage.of("Тестовое сообщение");
        String jsonContent = objectMapper.writeValueAsString(testMessage);
        
        mockMvc.perform(post("/hello")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonContent))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string("Привет из Spring Boot приложения! Сообщение: Тестовое сообщение"));
    }
    
    @Test
    void testHelloMessagePost_EmptyMessage() throws Exception {
        // Тестируем POST /hello с пустым сообщением
        String jsonContent = "{\"message\":\"\"}";
        
        mockMvc.perform(post("/hello")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonContent))
                .andDo(print())
                .andExpect(status().isBadRequest()) // Ожидаем ошибку валидации
                .andExpect(content().string("Ошибка валидации: Message cannot be empty"));
    }
    
    @Test
    void testHelloMessagePost_NullMessage() throws Exception {
        // Тестируем POST /hello с null сообщением
        String jsonContent = "{\"message\":null}";
        
        mockMvc.perform(post("/hello")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonContent))
                .andDo(print())
                .andExpect(status().isBadRequest()) // Ожидаем ошибку валидации
                .andExpect(content().string("Ошибка валидации: Message cannot be empty"));
    }
    
    @Test
    void testHelloMessagePost_InvalidJson() throws Exception {
        // Тестируем POST /hello с невалидным JSON
        String invalidJson = "{invalid json}";
        
        mockMvc.perform(post("/hello")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(invalidJson))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(content().string("Ошибка чтения JSON: невалидный формат данных"));
    }
    
    @Test
    void testHelloMessagePost_WithSpecialCharacters() throws Exception {
        // Тестируем POST /hello со специальными символами
        TestMessage testMessage = TestMessage.of("Привет! 🚀 Test ñáéíóú");
        String jsonContent = objectMapper.writeValueAsString(testMessage);
        
        mockMvc.perform(post("/hello")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonContent))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string("Привет из Spring Boot приложения! Сообщение: Привет! 🚀 Test ñáéíóú"));
    }
    
    @Test
    void testNonExistentEndpoint() throws Exception {
        // Тестируем несуществующий endpoint
        mockMvc.perform(get("/nonexistent"))
                .andDo(print())
                .andExpect(status().isNotFound());
    }
}