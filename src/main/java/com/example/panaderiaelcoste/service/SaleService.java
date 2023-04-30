package com.example.panaderiaelcoste.service;

import com.example.panaderiaelcoste.exception.SaleException;
import com.example.panaderiaelcoste.model.Employee;
import com.example.panaderiaelcoste.model.Sale;
import com.example.panaderiaelcoste.model.SaleDetail;

import java.util.ArrayList;

public interface SaleService {
    ArrayList<Sale> getSales();

    void addSale(Employee employee, ArrayList<SaleDetail> saleDetails) throws SaleException;
}

