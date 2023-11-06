FROM maven:3.8.4-openjdk-11
WORKDIR /app
COPY .mvn/ .mvn
COPY mvnw pom.xml ./
RUN mvn dependency:resolve
COPY src ./src
ADD target/gestion-station-ski-1.0.jar gestion-station-ski-1.0.jar
EXPOSE 8089
CMD ["mvn", "spring-boot:run"]
