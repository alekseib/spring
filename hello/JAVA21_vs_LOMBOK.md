# Java 21 Records vs Lombok

## 🎯 Простой пример: Todo бин

### ❌ Старый способ с Lombok:
```java
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Todo {
    private Long id;
    private String title;
    private String description;
    private boolean completed;
    private LocalDateTime createdAt;
}
```

### ✅ Java 21 Record (без зависимостей):
```java
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
    
    // Immutable update
    public Todo markCompleted() {
        return new Todo(id, title, description, true, createdAt);
    }
    
    // Валидация
    public Todo {
        if (title == null || title.trim().isEmpty()) {
            throw new IllegalArgumentException("Title cannot be empty");
        }
    }
}
```

## 🚀 Что автоматически генерируется:

| Feature | Lombok | Java 21 Record |
|---------|--------|----------------|
| Конструктор | @AllArgsConstructor | ✅ Автоматически |
| Геттеры | @Getter | ✅ `todo.title()` |
| equals() | @EqualsAndHashCode | ✅ Автоматически |
| hashCode() | @EqualsAndHashCode | ✅ Автоматически |
| toString() | @ToString | ✅ Автоматически |
| Immutable поля | final вручную | ✅ Автоматически |

## 📱 Использование:

```java
// Создание
var todo = Todo.create("Выучить Java 21", "Records и другие фичи");

// Доступ к данным
System.out.println(todo.title()); // "Выучить Java 21"
System.out.println(todo.completed()); // false

// Immutable update
var completedTodo = todo.markCompleted();
System.out.println(completedTodo.completed()); // true
System.out.println(todo.completed()); // false (оригинал не изменился!)

// Автоматический toString
System.out.println(todo);
// Todo[id=null, title=Выучить Java 21, description=Records и другие фичи, completed=false, createdAt=2024-...]
```

## 🎉 Преимущества Record над Lombok:

✅ **Нет зависимостей** - встроено в Java  
✅ **Immutable по умолчанию** - безопасность  
✅ **Лучшая производительность** - компилятор оптимизирует  
✅ **Читаемость** - весь код виден  
✅ **Отладка** - легче отлаживать  
✅ **Совместимость** - работает везде где есть Java 21+

## 🔧 Тестирование:

Запустите приложение и протестируйте endpoints:
- http://localhost:8080/todo - один Todo
- http://localhost:8080/todos - список Todo с разными статусами

## 💡 Рекомендация:

**Для новых проектов на Java 21+**: используйте **Records** вместо Lombok для простых data классов!