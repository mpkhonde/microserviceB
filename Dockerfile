# ===============================
# Basbild (Java 17)
# ===============================
FROM eclipse-temurin:17-jdk-alpine

# ===============================
# Mapp där appen ska köras
# ===============================
WORKDIR /app

# ===============================
# Kopierar jar-filen som byggs av Gradle
# ===============================
COPY build/libs/*.jar app.jar

# ===============================
# Port som Spring Boot använder
# ===============================
EXPOSE 8080

# ===============================
# Startar programmet
# ===============================
ENTRYPOINT ["java", "-jar", "app.jar"]
