FROM maven:3.8.6-openjdk-11-slim AS build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests
FROM adoptopenjdk:11-jre-hotspot-bionic
WORKDIR /app
COPY --from=build /app/target/my-app-1.0-SNAPSHOT.jar ./my-app-1.0-SNAPSHOT.jar
EXPOSE 8081
CMD ["java", "-jar", "my-app-1.0-SNAPSHOT.jar"]