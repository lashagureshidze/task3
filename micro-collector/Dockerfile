FROM amazoncorretto:11-alpine-jdk
COPY target/micro-collector-1.0-SNAPSHOT.jar /app.jar
EXPOSE 8083
ENTRYPOINT ["java","-jar","/app.jar"]