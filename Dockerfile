FROM openjdk:17-ea-11-jdk-slim
VOLUME /tmp
COPY build/libs/seller-service-1.0.jar seller-service.jar
ENTRYPOINT ["java", "-jar", "seller-service.jar"]
