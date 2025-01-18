# Use Maven to build the application
FROM maven:3.9.4-eclipse-temurin-17 AS build

# Set the working directory for Maven
WORKDIR /app

# Copy the Maven project files
COPY pom.xml .
COPY src ./src

# Build the application and package it as a JAR file
RUN mvn clean package -DskipTests

# Use the official OpenJDK image for the runtime
FROM openjdk:17-jdk-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the built JAR file from the Maven build stage
COPY --from=build /app/target/demo-*.jar app.jar

# Expose port 8080
EXPOSE 8080

# Run the application
CMD ["java", "-jar", "app.jar"]