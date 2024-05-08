FROM alpine:latest AS build

RUN apk update && apk add openjdk17 maven

COPY ../.. .

RUN mvn clean install

FROM openjdk:17-jdk-alpine

EXPOSE 8080

COPY --from=build /target/auth-1.0.0.jar /app/app.jar

ENTRYPOINT ["java", "-jar", "/app/app.jar"]
