package com.example.hello;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
public class MyHelloTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void testHelloEndpoint() throws Exception {
        TestMessage testMessage = TestMessage.of("Alex");
        String json = objectMapper.writeValueAsString(testMessage);

        mockMvc.perform(post("/hello/aaa")
                .contentType("application/json")
                .content(json))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string("Hi,Alex aaa"));
    };
}
