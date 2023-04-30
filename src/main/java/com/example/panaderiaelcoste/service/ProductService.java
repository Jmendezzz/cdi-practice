package com.example.panaderiaelcoste.service;

import com.example.panaderiaelcoste.model.Product;

import java.util.ArrayList;
import java.util.List;

public interface ProductService {
    List<Product> getProducts();

    void addProduct(Product product);

    void deleteProductById(String id);
}
