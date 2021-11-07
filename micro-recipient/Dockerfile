FROM amazoncorretto:11-alpine-jdk
COPY target/micro-recipient-1.0-SNAPSHOT.jar /app.jar
EXPOSE 8082
ENTRYPOINT ["java","-jar","/app.jar"]