# FROM maven:3.9-eclipse-temurin-17
# WORKDIR /app
# COPY target/*.jar app.jar
# CMD ["java","-jar","app.jar","--spring.profiles.active=docker"]
#CMD ["./mvnw", "spring-boot:run"]

FROM eclipse-temurin:17
WORKDIR /app
COPY . .
RUN chmod +x mvnw
CMD ["./mvnw", "spring-boot:run"]