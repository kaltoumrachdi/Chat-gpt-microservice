package org.sid.chatgptmicroservice;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@SpringBootApplication

public class ChatGpTmicroserviceApplication {
    public static void main(String[] args)
    {

        SpringApplication.run(ChatGpTmicroserviceApplication.class, args);
    }
}