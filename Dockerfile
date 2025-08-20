# ============================
# Etapa 1: Compilar con Maven
# ============================
FROM maven:3.9.8-eclipse-temurin-21 AS build
WORKDIR /app

# Copiar pom.xml y descargar dependencias primero (cache)
COPY pom.xml .
RUN mvn dependency:go-offline -B

# Copiar el código fuente
COPY src ./src

# Compilar y empacar la app
RUN mvn clean package -DskipTests

# ============================
# Etapa 2: Ejecutar la app
# ============================
FROM eclipse-temurin:21-jdk
WORKDIR /app

# Copiar el .jar generado en la etapa anterior
COPY --from=build /app/target/*.jar app.jar

# Exponer el puerto en el contenedor
EXPOSE 9090

# Ejecutar la app
ENTRYPOINT ["java", "-jar", "app.jar"]
