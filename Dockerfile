FROM maven:3.6.1-jdk-8-slim AS build
COPY src /usr/src/app/src
COPY pom.xml /usr/src/app
RUN mvn -f /usr/src/app/pom.xml clean install -DskipTests=true

#RUN mvn pom.xml clean install -DskipTests=true
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
COPY --from=build /usr/src/app/target/*.jar app.jar
#ADD target/*.jar app.jar
ENTRYPOINT ["java","-jar","app.jar"]