FROM maven:3-eclipse-temurin-17 AS build
LABEL athors="AlessandroFormicola"

WORKDIR /workspace/
COPY pom.xml /workspace/pom.xml
COPY src /workspace/src
RUN mvn clean package --file pom.xml

FROM openjdk:17-jdk-slim

COPY --from=build /workspace/target/*.jar /app/app.jar

ENTRYPOINT ["java","-jar","/app/app.jar"]