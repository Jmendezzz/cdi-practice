package com.example.panaderiaelcoste.service.imp;

import com.example.panaderiaelcoste.exception.ServiceJdbcException;
import com.example.panaderiaelcoste.model.Product;
import com.example.panaderiaelcoste.repository.ProductRepositoryImpl;
import com.example.panaderiaelcoste.service.ProductService;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Inject;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


@SessionScoped //Apply the singleton pattern
public class ProductImp implements ProductService,Serializable {


    @Inject
    private ProductRepositoryImpl productRepository;

    public ProductImp(){}

    @Override
    public List<Product> getProducts (){
        try{
            return productRepository.findAll();
        } catch (SQLException e) {
            throw new ServiceJdbcException(e.getMessage(),e.getCause());
        }
    }

    @Override
    public void addProduct(Product product) {
        System.out.println("**"+product.getPrice());
        productRepository.save(product);
    }

    @Override
    public void deleteProductById(String id){
        productRepository.delete(Long.valueOf(id));



    }


}
