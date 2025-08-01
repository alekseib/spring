# Запуск Spring Boot приложения в IntelliJ IDEA

## 🚀 Пошаговая инструкция:

### 1. Настройка Project SDK:
```
File → Project Structure → Project Settings → Project
- Project SDK: 21 (Eclipse Adoptium 21.0.8)
- Project language level: 21
```

### 2. Настройка Gradle:
```
File → Settings → Build, Execution, Deployment → Build Tools → Gradle
- Gradle JVM: Project SDK (corretto-21)
- Build and run using: Gradle (Recommended)
- Run tests using: Gradle (Recommended)
```

### 3. Способы запуска:

#### Способ A: Через main класс
1. Откройте: `src/main/java/com/example/hello/HelloApplication.java`
2. Кликните на зеленую стрелку рядом с `main` методом
3. Или нажмите `Ctrl+Shift+F10`

#### Способ B: Через Gradle Task
1. Откройте Gradle panel (справа)
2. `hello → Tasks → application → bootRun`
3. Двойной клик на `bootRun`

#### Способ C: Создать Run Configuration
1. `Run → Edit Configurations`
2. `+ → Spring Boot`
3. Настройки:
   - Name: `HelloApplication`
   - Main class: `com.example.hello.HelloApplication`
   - Use classpath of module: `hello.main`
   - JRE: 21

### 4. Проверка запуска:
После успешного запуска в логах должно быть:
```
Started HelloApplication in X.XXX seconds
Tomcat started on port 8080
```

Откройте в браузере: http://localhost:8080/

## 🔧 Если есть ошибки:

### Ошибка "Java 11 JVM":
- Проверьте что IDEA использует Java 21
- `File → Project Structure → Project SDK`

### Ошибка "Port 8080 already in use":
- Остановите другие Spring Boot приложения
- Или измените порт в `application.properties`: `server.port=8081`

### DevTools Hot Reload:
- Автоматически включен в development режиме
- Изменения в коде → Ctrl+S → автоматический перезапуск