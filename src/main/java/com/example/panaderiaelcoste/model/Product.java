package com.example.panaderiaelcoste.model;


import jakarta.enterprise.context.SessionScoped;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter @Setter
@SessionScoped
public class Product implements Serializable {
    private  static  int idCount;

    private Long id;
    private String name;
    private int avaibleAmount;
    private String urlImage;
    private boolean status;

    private double price;

    public Product(String name, int avaibleAmount, boolean status, double price,String urlImage) {
        this.name = name;
        this.avaibleAmount = avaibleAmount;
        this.status = status;
        this.price = price;
        this.urlImage = urlImage;
        this.id = (long) idCount;
        idCount++;
    }
    public Product(){}
}
