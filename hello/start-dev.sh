#!/bin/bash

echo "🚀 Запуск Spring Boot приложения в режиме разработки..."
echo "📝 DevTools включен для автоперезагрузки"
echo "🔄 LiveReload доступен на порту 35729"
echo ""
echo "📡 Доступные endpoints:"
echo "   http://localhost:8080/        - Hello World"
echo "   http://localhost:8080/hello   - Приветствие"
echo "   http://localhost:8080/test    - Тест"
echo ""
echo "💡 Совет: Активируйте LiveReload расширение в браузере!"
echo "⚠️  Для остановки используйте Ctrl+C"
echo ""

./gradlew bootRun