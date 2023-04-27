#FROM maven:3.8.2-jdk-8

#WORKDIR /spring-app
#COPY . .
#RUN mvn clean install -Dmaven.test.skip

#CMD mvn spring-boot:run
FROM maven:3.8.2-jdk-8

USER root
RUN mkdir -p /root/.m2/repository && \
    chown -R 1000:1000 /root/.m2

USER 1000
WORKDIR /spring-app
COPY . .
RUN mvn clean install -Dmaven.test.skip

CMD mvn spring-boot:run
