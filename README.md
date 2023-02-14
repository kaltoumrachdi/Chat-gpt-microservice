# chat-gpt-microservice


## Implemented features
* creating an endpoint to retrieve a question from the user 
* sending that question to OpenAI API and retrieving the answer
* sending the nswer to the user 
* storing the question and the answer in a csv file
* deploying that microservice in a docker container 
* storing my CSV file in a volume mapping a location in the host to a location in the container 

## Used technologies and tools 

- spring boot3
- java 17
- maven
- Docker
- postman


## creating a docker container Steps

> tap these commands in the application folder 

* docker build -t chat-gpt-microservice.jar .
* docker-compose up
> in the container terminal tap(we move our jarfile into container folder that we mapped to our host folder so that the csv file would be generated in the container  folder 
* mv /chat-gpt-microcervice.jar /container/chat-gpt-microservice.jar

 





