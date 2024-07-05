package com.iam57.akianime;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@SpringBootApplication
public class AkianimeApplication {

    public static void main(String[] args) {
        SpringApplication.run(AkianimeApplication.class, args);
    }

}
