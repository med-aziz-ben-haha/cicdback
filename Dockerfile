FROM openjdk:slim

COPY target/tpAchatProject-1.2.jar spring-app.jar

ENTRYPOINT ["java","-jar","/spring-app.jar"]
