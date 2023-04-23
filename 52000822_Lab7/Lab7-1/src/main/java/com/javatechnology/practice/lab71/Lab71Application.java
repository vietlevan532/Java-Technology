package com.javatechnology.practice.lab71;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Lab71Application {

    @Bean
    public CommandLineRunner runner() {
        return args -> System.out.println("Le Van Viet");
    }

    public static void main(String[] args) {
        SpringApplication.run(Lab71Application.class, args);
    }

}
