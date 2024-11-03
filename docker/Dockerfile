# Use an OpenJDK base image
FROM openjdk:11-jre-slim

# Set the working directory
WORKDIR /app

# Copy the application JAR file
COPY target/VPNProject.jar /app/VPNProject.jar

# Run the application
CMD ["java", "-jar", "VPNProject.jar", "server"]