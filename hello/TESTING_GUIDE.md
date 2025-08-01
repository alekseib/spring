# 🧪 Тестирование в Spring Boot

## 📋 Что мы протестировали

### 🎯 **HelloController тесты:**

1. **GET /** - проверяем возврат "Hello World! -1156"
2. **GET /hello** - проверяем русское приветствие  
3. **POST /hello** - тестируем с разными сценариями:
   - ✅ Валидное сообщение
   - ❌ Пустое сообщение
   - ❌ Null сообщение
   - ❌ Невалидный JSON
   - ✅ Специальные символы и Unicode
4. **404 ошибка** - несуществующий endpoint

### 🎯 **TestMessage Record тесты:**

1. **Создание объекта** - через конструктор и фабричный метод
2. **Валидация** - null, пустые строки, пробелы
3. **equals/hashCode** - автоматическая генерация работает
4. **toString** - формат Record'а
5. **Unicode поддержка** - эмодзи и спецсимволы

## 🔧 **Технологии тестирования:**

### @WebMvcTest
```java
@WebMvcTest(HelloController.class) // Загружает только web-слой
```
- Быстрые тесты (не запускает всё приложение)
- Только контроллеры и web-конфигурация
- MockMvc для имитации HTTP запросов

### MockMvc
```java
mockMvc.perform(get("/"))
    .andExpect(status().isOk())
    .andExpect(content().string("Hello World!"));
```

### JUnit 5 + AssertJ
```java
@Test
void testValidMessage() {
    assertEquals("test", message.message());
    assertThrows(IllegalArgumentException.class, () -> new TestMessage(null));
}
```

## 🚀 **Команды для запуска:**

```bash
# Все тесты
./gradlew test

# Только определенный класс
./gradlew test --tests HelloControllerTest

# Только определенный метод
./gradlew test --tests HelloControllerTest.testHelloEndpoint

# С подробным выводом
./gradlew test --info

# Генерация отчета (build/reports/tests/test/index.html)
./gradlew test --continue
```

## 📊 **Что тестируют наши тесты:**

| Тест | Что проверяем | Ожидаемый результат |
|------|---------------|-------------------|
| `testHelloEndpoint()` | GET / | 200 + текст |
| `testHelloMessageEndpoint()` | GET /hello | 200 + русский текст |
| `testHelloMessagePost_ValidMessage()` | POST с данными | 200 + ответ с сообщением |
| `testHelloMessagePost_EmptyMessage()` | POST с пустым | 400 Bad Request |
| `testNullMessage()` | Record валидация | IllegalArgumentException |
| `testEqualsAndHashCode()` | Record методы | Правильное сравнение |

## 🎯 **Покрытие кода:**

Наши тесты покрывают:
- ✅ **100%** методов HelloController
- ✅ **100%** функциональности TestMessage
- ✅ **Валидацию** на всех уровнях
- ✅ **Edge cases** (null, пустые строки, спецсимволы)
- ✅ **HTTP статусы** и заголовки

## 💡 **Best Practices:**

1. **@WebMvcTest** для контроллеров (быстро)
2. **@DataJpaTest** для репозиториев  
3. **@SpringBootTest** для интеграционных тестов
4. **AssertJ** для читаемых assertions
5. **Тестируйте edge cases** (null, пустые значения)
6. **Один тест = одна проверка**
7. **Описательные имена тестов**