# Предметная область: Музыкальный альбом
### Композиция: Альбом - Песни

### Описание:
Музыкальный альбом - это сборник песен или музыкальных композиций, выпущенных в виде одного продукта. Таким образом, объекты Альбом - Песни имеют связь "один ко многим".
- Свойства объекта Альбом: название, исполнители, жанр, год выпуска, количество песен.
- Свойства объекта Песня: название, текст, исполнители, продолжительность, ссылка на альбом.

### Зависимости

- Spring Boot 3.1.0
- Spring Boot Web 3.1.0
- Spring Data JPA 3.0.4
- MySQL Connector 8.0.33

### Сборка

Для сборки проекта выполните следующие шаги:

1. Убедитесь, что у вас установлен Maven.
2. Откройте командную строку (терминал) в корневой директории проекта.
3. Выполните команду: `mvn clean install`

### Запуск

Для запуска приложения выполните следующие шаги:

1. Убедитесь, что у вас установлена JDK версии 19.
2. Откройте командную строку (терминал) в корневой директории проекта.
3. Выполните команду: `mvn spring-boot:run`
4. Подождите, пока приложение успешно запустится.