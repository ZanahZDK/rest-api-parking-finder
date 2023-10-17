# Usa una imagen base de Maven con JDK incluido
FROM maven:3.8.3-openjdk-17

# Establece el directorio de trabajo en el contenedor
WORKDIR /app

# Copia el proyecto al contenedor
COPY . .

# Ejecuta Maven para construir el proyecto
RUN mvn clean install -DskipTests  # Omite las pruebas para acelerar la construcción

# Especifica el puerto que la aplicación escuchará
EXPOSE 8080

# Ejecuta la aplicación
CMD ["java", "-jar", "target/api-rest-0.0.1-SNAPSHOT.jar"]
