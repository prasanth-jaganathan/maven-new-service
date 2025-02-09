# Stage 1: Build the application using Maven
FROM maven:3.9.2 as builder

# Set the working directory inside the container
WORKDIR /build

# Copy the pom.xml and the source code
COPY pom.xml .
COPY src ./src

# Build the application
RUN mvn clean package -DskipTests

# Stage 2: Run the application with OpenJDK
FROM openjdk:17

# Set the working directory inside the%s:my-app container
WORKDIR /app

# Copy the built jar file from the builder stage
COPY --from=builder /build/target/my-app-1.0-SNAPSHOT.jar app.jar

# Expose the port the app runs on
EXPOSE 8080

# Run the jar file
ENTRYPOINT ["java", "-jar", "app.jar"]
