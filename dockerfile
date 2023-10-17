# Etapa 1: Construye la aplicación con Maven
FROM maven:3.9.5-openjdk-17 AS build
WORKDIR /app
COPY pom.xml .
RUN mvn dependency:go-offline
COPY src src
RUN mvn package -DskipTests

# Etapa 2: Ejecuta la aplicación Java con el archivo JAR generado
FROM openjdk:17-jdk-slim
WORKDIR /app
COPY --from=build target/api-rest-0.0.1-SNAPSHOT.jar api-rest-0.0.1-SNAPSHOT.jar
EXPOSE 8080
CMD ["java", "-jar", "api-rest-0.0.1-SNAPSHOT.jar"]

