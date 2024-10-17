FROM amazoncorretto:21-alpine-jdk

COPY target/candidate-0.0.1-SNAPSHOT.war app.war

ENTRYPOINT ["java", "-jar" , "/app.war"]