package com.javatechnology.practice.lab65;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@Configuration
@PropertySources({
        @PropertySource("classpath:/application.properties")
})
public class AppConfig {

    @Bean
    public Product product() {
        return new Product();
    }

}
