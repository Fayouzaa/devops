# Use an OpenJDK base image with a package manager
FROM openjdk:11-jre-slim

# Set the working directory inside the container


# Copy the compiled Spring Boot JAR file into the container
ADD target/gestion-station-ski-1.0.jar app.jar

# Expose the port on which your Spring Boot application runs (e.g., 8080)
EXPOSE 8080

# Command to run the Spring Boot application
CMD ["java", "-jar", "app.jar"]
