package com.codecool.diceroll;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Random;

@SpringBootApplication
@EnableSwagger2
@EnableEurekaClient
public class DiceRollApplication {

    public static void main(String[] args) {
        SpringApplication.run(DiceRollApplication.class, args);
    }

    @Bean
    public Random random() {
        return new Random();
    }

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.ant("/roll/**"))
                .build();
    }

}
