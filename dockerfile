FROM openjdk:21-jdk-slim
WORKDIR /app
COPY build/libs/DatastoreMsApplication.jar DatastoreMs.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "DatastoreMs.jar"]