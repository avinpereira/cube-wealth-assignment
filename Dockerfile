#FROM maven:3.6.1-jdk-8-slim AS build
#RUN mkdir -p /workspace
#WORKDIR /workspace
#COPY pom.xml /workspace
#COPY src /workspace/src
#RUN mvn -f pom.xml clean package
#
#FROM java:8
#COPY target/event-app.jar app.jar
#EXPOSE 8080
#ENTRYPOINT ["java","-jar","app.jar"]


FROM adoptopenjdk/openjdk11:alpine-jre
ADD target/event-ingestor-service.jar /app.jar
ENTRYPOINT ["java","-XX:+PrintCodeCache","-jar","app.jar"]
