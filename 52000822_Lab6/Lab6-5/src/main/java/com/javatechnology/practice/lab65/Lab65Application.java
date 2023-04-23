package com.javatechnology.practice.lab65;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Lab65Application {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        Product product = (Product) context.getBean("product");
        System.out.println(product);
    }

}
