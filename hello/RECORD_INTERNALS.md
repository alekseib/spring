# 🔍 Как работают Records в Java 21

## 🧬 Что происходит под капотом

### 1️⃣ **Ваш код:**
```java
public record Person(String name, int age) {}
```

### 2️⃣ **Что генерирует компилятор:**
```java
public final class Person extends java.lang.Record {
    private final String name;
    private final int age;
    
    // Конструктор
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    
    // Геттеры (accessor methods)
    public String name() { return this.name; }
    public int age() { return this.age; }
    
    // equals
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Person person = (Person) obj;
        return age == person.age && Objects.equals(name, person.name);
    }
    
    // hashCode
    public int hashCode() {
        return Objects.hash(name, age);
    }
    
    // toString
    public String toString() {
        return "Person[name=" + name + ", age=" + age + "]";
    }
}
```

## ⚙️ **Процесс компиляции:**

1. **Парсинг**: `javac` распознает ключевое слово `record`
2. **AST генерация**: Создается абстрактное синтаксическое дерево
3. **Код генерация**: Автоматически добавляются методы
4. **Bytecode**: Генерируется `.class` файл с полным кодом

## 🔬 **Ключевые особенности:**

### ✅ **Автоматически генерируется:**
- Конструктор с всеми параметрами
- Accessor методы (`name()`, `age()`)  
- `equals()`, `hashCode()`, `toString()`
- `final` класс и поля

### ✅ **Наследование:**
- Все Records наследуют `java.lang.Record`
- Нельзя наследовать от других классов
- Нельзя создать подклассы Record

### ✅ **Immutability:**
- Все поля `private final`
- Нет setter'ов
- Thread-safe по умолчанию

## 🧪 **Демонстрация в коде:**

Запустите endpoints для понимания:
- `/explain/record` - сравнение Record vs обычный класс
- `/explain/methods` - какие методы генерируются
- `/explain/compilation` - что делает компилятор

## 💡 **Почему Records быстрее Lombok:**

| Aspect | Lombok | Record |
|--------|--------|--------|
| **Компиляция** | Annotation Processing | Прямая генерация кода |
| **Runtime** | Reflection magic | Обычные методы |
| **Bytecode** | Сложный + метаданные | Простой и чистый |
| **JVM оптимизации** | Ограниченные | Полные |

## 🎯 **Практические отличия:**

### Record геттеры:
```java
person.name()    // Record style
person.getName() // Traditional style
```

### Immutability:
```java
// Record - immutable
var person = new Person("John", 25);
// person.setAge(26); // ❌ Нет такого метода!

// Нужно создать новый
var olderPerson = new Person(person.name(), 26);
```

### Pattern Matching (Java 21):
```java
// Деструктуризация в switch
switch (person) {
    case Person(var name, var age) when age >= 18 -> 
        "Взрослый: " + name;
    case Person(var name, var age) -> 
        "Ребенок: " + name;
}
```

## 🚀 **Вывод:**

Records - это **синтаксический сахар** на уровне компилятора, который генерирует **обычный Java код**. Никакой магии во время выполнения!