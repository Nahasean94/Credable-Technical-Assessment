# Use an official OpenJDK runtime as a parent image
FROM openjdk:21-jdk-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the JAR file into the container
COPY build/libs/Credable-Technical-Assessment-0.0.1-SNAPSHOT.jar app.jar

# Expose the application port
EXPOSE 8190

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
