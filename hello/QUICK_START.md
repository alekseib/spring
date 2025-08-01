# 🚀 Быстрый старт Development Workflow

## 1️⃣ Запуск приложения
```bash
# Linux/Mac
./start-dev.sh

# Windows
start-dev.bat

# Или напрямую
./gradlew bootRun
```

## 2️⃣ Настройка IDEA (один раз)
1. **Settings** → **Compiler** → ✅ **Build project automatically**
2. **Settings** → **Advanced Settings** → ✅ **Allow auto-make to start even if developed application is currently running**

*Примечание: В новых версиях IDEA эта опция находится в Advanced Settings → Compiler*

## 3️⃣ Опционально: LiveReload для автообновления браузера
**⚠️ Старое расширение LiveReload устарело в Chrome!**

**Альтернативы:**
- [Live Server Web Extension](https://chrome.google.com/webstore/detail/live-server-web-extension/fiegdmejfepffgpnejdinekhfieaogmj) (Chrome)
- [LiveReload Add-on](https://addons.mozilla.org/firefox/addon/livereload-web-extension/) (Firefox)
- **Или работайте без расширения** - просто обновляйте браузер вручную (F5)

## 4️⃣ Тестирование
1. Откройте http://localhost:8080
2. **С LiveReload**: активируйте расширение, автообновление
3. **Без LiveReload**: измените код → сохраните → обновите браузер (F5)
4. Приложение перезагружается за 1-3 секунды! ⚡

## 📡 Endpoints для тестирования
- `http://localhost:8080/` - Hello World
- `http://localhost:8080/hello` - Приветствие на русском
- `http://localhost:8080/test` - Тестовая страница

## ⚡ Что происходит автоматически:
1. **Изменили код** → IDEA компилирует
2. **Файл скомпилирован** → DevTools перезагружает приложение  
3. **Приложение перезагружено** → Обновите браузер (F5) или LiveReload (если работает)

**Время перезагрузки приложения: ~1-3 секунды!** ⚡  
**+ 1 секунда на ручное обновление браузера** = все равно очень быстро!

---
📖 Подробная документация: [DEVELOPMENT_WORKFLOW.md](DEVELOPMENT_WORKFLOW.md)