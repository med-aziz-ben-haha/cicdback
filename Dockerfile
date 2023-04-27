#FROM maven:3.8.2-jdk-8

#WORKDIR /spring-app
#COPY . .
#RUN mvn clean install -Dmaven.test.skip

#CMD mvn spring-boot:run*/

FROM maven:3.8.2-jdk-8

# Create a new user and group with UID and GID 1000
RUN groupadd -g 1000 myuser && \
    useradd -u 1000 -g 1000 -ms /bin/bash myuser

WORKDIR /spring-app
COPY . .
RUN chown -R myuser:myuser /spring-app

USER myuser
RUN mvn clean install -Dmaven.test.skip

CMD mvn spring-boot:run
