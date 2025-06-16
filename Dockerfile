# Stage 1: Build the application using Gradle with Java 17
FROM gradle:8.7-jdk17 AS build
WORKDIR /app

# Copy Gradle wrapper files and project configuration
COPY build.gradle.kts settings.gradle.kts gradlew ./
COPY gradle gradle
COPY src src

# Grant execution rights to the Gradle wrapper
RUN chmod +x ./gradlew

# Build the application (skip tests to speed up build)
RUN ./gradlew clean build -x test

# Stage 2: Create the runtime image using OpenJDK 17
FROM openjdk:17-jdk
WORKDIR /app
VOLUME /tmp

# Copy the built JAR from the Gradle build stage
COPY --from=build /app/build/libs/*.jar app.jar

# Define the entrypoint
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
EXPOSE 8080