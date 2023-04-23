package com.javatechnology.practice.lab65;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Product {

    @Value("${product.id}")
    private int id;

    @Value("${product.name}")
    private String name;

    @Value("${product.price}")
    private double price;

    @Value("${product.description}")
    private String description;

    @Override
    public String toString() {
        return "Product [id=" + id + ", name=" + name + ", price=" + price + ", description=" + description + "]";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
