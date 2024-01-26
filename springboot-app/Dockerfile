FROM maven:3.8.4-openjdk-11-slim AS build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests
FROM adoptopenjdk:11-jre-hotspot-bionic
WORKDIR /app
COPY --from=build /app/target/spring-boot-jacoco.jar ./spring-boot-jacoco.jar
EXPOSE 8081
CMD ["java", "-jar", "spring-boot-jacoco.jar"]
