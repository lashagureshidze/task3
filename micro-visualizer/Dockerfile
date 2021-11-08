FROM amazoncorretto:11-alpine-jdk
COPY target/micro-visualizer-1.0-SNAPSHOT.jar /app.jar
EXPOSE 8084
ENTRYPOINT ["java","-jar","/app.jar"]