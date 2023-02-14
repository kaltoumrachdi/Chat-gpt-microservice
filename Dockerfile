FROM openjdk:17
EXPOSE 8080
ADD /chat-gpt-microservice.jar chat-gpt-microservice.jar
ENTRYPOINT ["java","-jar","/chat-gpt-microservice.jar"]