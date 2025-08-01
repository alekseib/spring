package com.example.hello;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Юнит-тесты для TestMessage Record
 */
class TestMessageTest {
    
    @Test
    void testValidMessage() {
        // Тест создания валидного сообщения
        String message = "Тестовое сообщение";
        TestMessage testMessage = new TestMessage(message);
        
        assertEquals(message, testMessage.message());
    }
    
    @Test
    void testValidMessageWithFactory() {
        // Тест создания сообщения через фабричный метод
        String message = "Сообщение через фабрику";
        TestMessage testMessage = TestMessage.of(message);
        
        assertEquals(message, testMessage.message());
    }
    
    @Test
    void testNullMessage() {
        // Тест с null сообщением
        IllegalArgumentException exception = assertThrows(
            IllegalArgumentException.class, 
            () -> new TestMessage(null)
        );
        
        assertEquals("Message cannot be empty", exception.getMessage());
    }
    
    @Test
    void testEmptyMessage() {
        // Тест с пустым сообщением
        IllegalArgumentException exception = assertThrows(
            IllegalArgumentException.class,
            () -> new TestMessage("")
        );
        
        assertEquals("Message cannot be empty", exception.getMessage());
    }
    
    @Test
    void testWhitespaceMessage() {
        // Тест с сообщением из пробелов
        IllegalArgumentException exception = assertThrows(
            IllegalArgumentException.class,
            () -> new TestMessage("   ")
        );
        
        assertEquals("Message cannot be empty", exception.getMessage());
    }
    
    @Test
    void testEqualsAndHashCode() {
        // Тест equals и hashCode (автоматически генерируются для Record)
        TestMessage message1 = TestMessage.of("test");
        TestMessage message2 = TestMessage.of("test");
        TestMessage message3 = TestMessage.of("different");
        
        // equals
        assertEquals(message1, message2);
        assertNotEquals(message1, message3);
        
        // hashCode
        assertEquals(message1.hashCode(), message2.hashCode());
        assertNotEquals(message1.hashCode(), message3.hashCode());
    }
    
    @Test
    void testToString() {
        // Тест toString (автоматически генерируется для Record)
        TestMessage message = TestMessage.of("hello");
        String toStringResult = message.toString();
        
        assertTrue(toStringResult.contains("TestMessage"));
        assertTrue(toStringResult.contains("hello"));
        
        // Record toString format: ClassName[field1=value1, field2=value2]
        assertEquals("TestMessage[message=hello]", toStringResult);
    }
    
    @Test
    void testMessageWithSpecialCharacters() {
        // Тест с Unicode и специальными символами
        String specialMessage = "Привет! 🚀 Test ñáéíóú #@$%";
        TestMessage testMessage = TestMessage.of(specialMessage);
        
        assertEquals(specialMessage, testMessage.message());
    }
}