# 1. Build stage: Use official Maven with JDK 17
FROM maven:3.8-openjdk-17 AS builder

# 2. Set the working directory inside the container
WORKDIR /app

# 3. Copy pom.xml and source code into the container
COPY pom.xml .
COPY src ./src

# 4. Compile and package the project
RUN mvn clean package -DskipTests

# 5. Runtime stage: Use a lightweight JRE 17 image
FROM eclipse-temurin:17-jre

# 6. Set the working directory for runtime
WORKDIR /app

# 7. Copy the generated jar and the lib folder from the builder stage
COPY --from=builder /app/target/calculator-1.0-SNAPSHOT.jar .
COPY --from=builder /app/target/lib ./lib

# 8. Set the entrypoint to run the calculator jar
ENTRYPOINT ["java", "-jar", "calculator-1.0-SNAPSHOT.jar"]