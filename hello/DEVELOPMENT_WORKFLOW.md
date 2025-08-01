# Spring Boot Development Workflow

## 🚀 Быстрая настройка

### 1. Spring Boot DevTools
✅ **Уже настроено!** Зависимость добавлена в `build.gradle`:
```gradle
developmentOnly 'org.springframework.boot:spring-boot-devtools'
```

### 2. Настройки DevTools в application.properties
✅ **Уже настроено!** Конфигурация:
```properties
spring.devtools.restart.enabled=true
spring.devtools.livereload.enabled=true
spring.devtools.restart.poll-interval=1000
spring.devtools.restart.quiet-period=400
```

### 3. Настройка IntelliJ IDEA

#### 3.1 Включите автоматическую компиляцию:
1. **File → Settings** (Ctrl+Alt+S)
2. **Build, Execution, Deployment → Compiler**
3. ✅ Включите **"Build project automatically"**

#### 3.2 Разрешите auto-make во время работы приложения:

**Для новых версий IDEA (2021.2+):**
1. **File → Settings → Advanced Settings**
2. В разделе **Compiler** найдите опцию:
   - **"Allow auto-make to start even if developed application is currently running"**
   - Или **"Compiler → Allow auto-make to start even if developed application is currently running"**
3. ✅ Установите галочку

**Для старых версий IDEA:**
1. **Help → Find Action** (Ctrl+Shift+A)
2. Найдите **"Registry"**
3. Найдите `compiler.automake.allow.when.app.running`
4. ✅ Установите в **true**

### 4. LiveReload в браузере

#### Установите расширение LiveReload:
- **Chrome**: [LiveReload Extension](https://chrome.google.com/webstore/detail/livereload/jnihajbhpnppcggbcgedagnkighmdlei)
- **Firefox**: [LiveReload Add-on](https://addons.mozilla.org/en-US/firefox/addon/livereload-web-extension/)
- **Edge**: [LiveReload Extension](https://microsoftedge.microsoft.com/addons/detail/livereload/pekmijcnjdlfioppjlijnpcipjljabjk)

#### Активация LiveReload:
1. Запустите приложение
2. Откройте браузер на `http://localhost:8080`
3. **Нажмите на иконку LiveReload** в браузере для активации

## 🔄 Полный Workflow

### Запуск приложения
```bash
# Убедитесь, что находитесь в папке hello/
cd hello
./gradlew bootRun
```
*Или в Windows:*
```cmd
cd hello
gradlew.bat bootRun
```

### Цикл разработки:
1. **Изменяете код** → 
2. **IDEA автоматически компилирует** → 
3. **DevTools перезагружает приложение** → 
4. **LiveReload обновляет браузер** 🎉

## ⚡ Дополнительные советы

### Hot Swap vs Restart
- **Hot Swap**: изменения методов (быстро)
- **Restart**: изменения классов, зависимостей (медленно, но быстрее полного перезапуска)

### Исключения из автоперезагрузки
Если нужно исключить определенные папки, добавьте в `application.properties`:
```properties
spring.devtools.restart.exclude=static/**,public/**,templates/**
```

### Отладка
1. В IDEA: **Run → Debug** (Shift+F9)
2. Установите breakpoints
3. DevTools работает в debug режиме!

### Проверка работы LiveReload
1. Откройте Developer Tools в браузере (F12)
2. В консоли должно появиться: `LiveReload enabled`
3. При изменениях увидите: `LiveReload reloading page`

## 🔍 Troubleshooting

### DevTools не работает:
1. Проверьте, что приложение запущено через IDE или `gradlew bootRun`
2. Убедитесь, что зависимость `developmentOnly`
3. Проверьте настройки в `application.properties`

### LiveReload не работает:
1. Проверьте активацию расширения в браузере
2. Убедитесь, что `spring.devtools.livereload.enabled=true`
3. Проверьте, что нет блокировки порта 35729

### IDEA не компилирует автоматически:
1. Проверьте настройки компилятора
2. Убедитесь, что проект импортирован как Gradle проект
3. Попробуйте **Build → Rebuild Project**

## 🎯 Готово!
Теперь у вас полнофункциональный workflow для быстрой разработки!