# Use an official OpenJDK runtime as a parent image
FROM openjdk:23-slim-bullseye

# Set the working directory in the container
WORKDIR /app

# Copy the application JAR file into the container
COPY build/libs/demo-0.0.1.jar app.jar

# Expose the port that the application will run on
EXPOSE 8080

# Define the command to run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
