FROM openjdk:11-jre-slim
WORKDIR /app
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} /app
RUN mvn clean package
EXPOSE 8080

ENTRYPOINT ["java","-jar","/hello-app-0.0.1.jar"]
