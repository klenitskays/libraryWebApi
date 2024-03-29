# libraryWebApi
# Инструкции по тестированию приложения "LibraryWebApi"

Этот файл содержит инструкции по тестированию приложения "LibraryWebApi", которое предоставляет API для управления книгами в библиотеке.

## Предварительные требования

Перед началом тестирования убедитесь, что у вас установлены и сконфигурированы следующие компоненты:

1. JDK (Java Development Kit) версии 8 или выше.
2. Среда разработки, такая как IntelliJ IDEA или Eclipse.
3. PostgreSQL сервер и база данных. Убедитесь, что у вас есть доступ к серверу базы данных и учетные данные для подключения.

## Шаги для тестирования приложения

1. Клонирование репозитория:
   - Склонируйте репозиторий "LibraryWebApi" на ваш локальный компьютер.

2. Конфигурация базы данных:
   - В файле `application.properties` (или `application.yml`) укажите данные вашей базы данных PostgreSQL, такие как URL, имя пользователя и пароль.
   - Убедитесь, что сервер базы данных запущен и доступен.

3. Запуск приложения:
   - Откройте проект в выбранной вами среде разработки.
   - Откройте класс Main.
   - Запустите приложение, щелкнув правой кнопкой мыши на классе `LibraryServiceApplication` и выбрав "Run" (Запустить).
   - Также проверьте, чтобы порт localhost:8081 не был использован, его можно переименовать в `application.properties`.

4. Тестирование API с использованием Postman:

   - Откройте Postman или другой инструмент для тестирования API.

   - Создание книги (HTTP POST):
     - URL: `http://localhost:8081/books`
     - Тело запроса (в формате JSON):
       ```json
       {
           "isbn": 1234567890,
           "title": "Название книги",
           "genre": "Жанр книги",
           "author": "Автор книги",
           "borrowedTime": "2023-11-30"
       }
       ```
     - Отправьте запрос и проверьте, что книга успешно создана.

   - Получение всех книг (HTTP GET):
     - URL: `http://localhost:8081/books`
     - Отправьте запрос и проверьте, что получены все книги в библиотеке.

   - Получение книги по ID (HTTP GET):
     - URL: `http://localhost:8081/books/id/{id}`
     - Замените `{id}` на фактический идентификатор книги.
     - Отправьте запрос и проверьте, что получена книга с указанным идентификатором.

   - Получение книги по ISBN (HTTP GET):
     - URL: `http://localhost:8081/books/isbn/{isbn}`
     - Замените `{isbn}` на фактический ISBN книги.
     - Отправьте запрос и проверьте, что получена книга с указанным ISBN.

   - Получение доступных книг (HTTP GET):
     - URL: `http://localhost:8081/books/available`
     - Отправьте запрос и проверьте, что получены только доступные книги (не занятые на прокат).

   - Обновление книги (HTTP PUT):
     - URL: `http://localhost:8081/books/id/{id}`
     - Замените `{id}` на фактический идентификатор книги.
     - Тело запроса (в формате JSON):
       ```json
       {
           "isbn": 1234567890,
           "title": "Новое название книги",
           "genre": "Новый жанр книги",
           "author": "Новый автор книги"
       }
       ```
     - Отправьте запрос и проверьте, что книга успешно обновлена с указанными значениями.

   - Удаление книги (HTTP DELETE):
     - URL: `http://localhost:8081/books/id/{id}`
     - Замените `{id}` на фактический идентификатор книги.
     - Отправьте запрос и проверьте, что книга успешно удалена.

5. Проверка результатов:
   - В каждом запросе вы должны получить соответствующий статус ответа HTTP и данные книги (если применимо).

