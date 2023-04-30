package com.example.panaderiaelcoste.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SaleDetail {

    private Product product;
    private int amount;


    public SaleDetail() {}
    @JsonCreator
    public SaleDetail(@JsonProperty("product") Product product, @JsonProperty("amount") int amount) {
        this.product = product;
        this.amount = amount;
    }
}
