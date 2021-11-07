FROM amazoncorretto:11-alpine-jdk
COPY target/micro-sender-1.0-SNAPSHOT.jar /app.jar
EXPOSE 8081
ENTRYPOINT ["java","-jar","/app.jar"]