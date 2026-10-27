FROM maven:3.9-eclipse-temurin-17 AS builder

WORKDIR /app

COPY pom.xml .
COPY src ./src

RUN mvn clean package -DskipTests

FROM eclipse-temurin:17-jre

WORKDIR /app

COPY --from=builder /app/target/calculator-1.0-SNAPSHOT.jar .
COPY --from=builder /app/target/lib ./lib

ENTRYPOINT ["java", "-jar", "calculator-1.0-SNAPSHOT.jar"]