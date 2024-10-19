FROM openjdk:22-jdk-slim AS build

LABEL authors="hazem"

WORKDIR /app

COPY mvnw pom.xml ./
COPY .mvn ./.mvn
RUN chmod +x mvnw
RUN ./mvnw dependency:go-offline -B -T 1C

COPY src ./src
RUN ./mvnw package -DskipTests -T 1C

FROM openjdk:22-jdk-slim

WORKDIR /app

COPY --from=build /app/target/*.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]