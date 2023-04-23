package com.example.Lab04_3.service;

import com.example.Lab04_3.model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductService {
    List<Product> products;

    public ProductService() {
        products = new ArrayList<>();
        products.add(new Product(2L, "Iphone 11 Pro 128GB", 1111));
        products.add(new Product(3L, "Iphone 12 Pro 128GB", 2222));
        products.add(new Product(4L, "Iphone 13 Pro 128GB", 3333));
        products.add(new Product(5L, "Iphone 14 Pro 128GB", 4444));

    }

    public List<Product> getProducts() {
        return products;
    }
}
