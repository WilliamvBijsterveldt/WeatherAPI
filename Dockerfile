FROM openjdk:18
EXPOSE 8080
ADD target/springboot-image-weatherapi.jar springboot-image-weatherapi.jar
ENTRYPOINT ["java", "-jar", "/springboot-image-weatherapi.jar"]