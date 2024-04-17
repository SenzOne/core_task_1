# Используйте официальный образ Java 17 как базовый
FROM maven:3.8.4-openjdk-17-slim AS builder

# Устанавливаем рабочую директорию внутри контейнера
WORKDIR /app

# Копируем исходный код приложения в контейнер
COPY . .

# Компилируем приложение
RUN mvn clean package -DskipTests

# Используем официальный образ OpenJDK для запуска приложения
FROM openjdk:17-jdk-slim

# Устанавливаем рабочую директорию внутри контейнера
WORKDIR /app

# Копируем собранный jar файл из стадии сборки
COPY --from=builder /app/target/*.jar app.jar

# Задаем переменные окружения для конфигурации Spring Boot
ENV SPRING_DATASOURCE_URL=jdbc:postgresql://localhost:5432/mydatabase \
    SPRING_DATASOURCE_USERNAME=myuser \
    SPRING_DATASOURCE_PASSWORD=secretpassword111 \
    SPRING_DATASOURCE_DRIVER_CLASS_NAME=org.postgresql.Driver \
    SPRING_JPA_HIBERNATE_DDL_AUTO=update \
    SPRING_JPA_SHOW_SQL=true \
    SPRING_LOGGING_LEVEL_ORG_SPRINGFRAMEWORK=DEBUG \
    SERVER_PORT=8081

# Запускаем приложение
ENTRYPOINT ["java", "-jar", "app.jar"]
