FROM maven:3.8.4-openjdk-11

WORKDIR /app

COPY .mvn/ .mvn
COPY mvnw pom.xml ./
RUN mvn dependency:resolve

COPY src ./src
ADD target/gestion-station-ski-1.0.jar app.jar

# Expose the port on which your Spring Boot application runs (e.g., 8080)
EXPOSE 8089

CMD ["mvn", "spring-boot:run"]
