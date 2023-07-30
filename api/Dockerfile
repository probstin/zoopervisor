FROM eclipse-temurin:17-jdk-alpine as build

WORKDIR /app

COPY gradlew .
COPY gradle gradle
COPY build.gradle .
COPY src src

RUN ./gradlew build -x test

FROM eclipse-temurin:17-jre-alpine

ARG JAR_FILE=/app/build/libs/*.jar

COPY --from=build ${JAR_FILE} app.jar

ENTRYPOINT ["java","-jar","/app.jar"]