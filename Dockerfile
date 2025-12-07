FROM eclipse-temurin:17-jdk-alpine

# Skapa arbetskatalog
WORKDIR /app

# Kopiera hela jar-filen (den skapas när du kör ./gradlew bootJar)
COPY build/libs/*.jar app.jar

# Exponera container-porten (Spring Boot kör på 8080)
EXPOSE 8080

# Kör appen
ENTRYPOINT ["java", "-jar", "app.jar"]
