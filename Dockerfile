# Stage 1: Build the application
FROM maven:3.9-eclipse-temurin-17-alpine AS builder
WORKDIR /app
COPY pom.xml .
COPY src src

# Build the project
RUN mvn clean package -DskipTests

# Stage 2: Run the application
FROM eclipse-temurin:17-jre-alpine
WORKDIR /app

# Create a volume for uploads
VOLUME /app/uploads

# Copy the built jar from the builder stage
COPY --from=builder /app/target/LostAndFound-1.0-SNAPSHOT.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]
