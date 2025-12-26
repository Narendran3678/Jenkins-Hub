#Start with a base image containing Java runtime
FROM openjdk:26-ea-jdk-slim

# Add the application's jar to the image
COPY Spring-boot-jenkins-demo/target/jenkinsdemo-1.0.jar jenkinsdemo-1.0.jar

# execute the application
ENTRYPOINT ["java","-jar","jenkinsdemo-1.0.jar"]
