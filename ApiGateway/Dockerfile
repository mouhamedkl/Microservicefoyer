FROM maven:3.8.3-openjdk-17 AS build
COPY src /home/app/src
COPY pom.xml /home/app

RUN mvn -f /home/app/pom.xml clean package -DskipTests
EXPOSE 8222
ENTRYPOINT ["java","-jar","/home/app/target/ApiGateway-1.jar"]
