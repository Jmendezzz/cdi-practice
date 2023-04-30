package com.example.panaderiaelcoste.service.imp;

import com.example.panaderiaelcoste.exception.SaleException;
import com.example.panaderiaelcoste.model.Employee;
import com.example.panaderiaelcoste.model.Sale;
import com.example.panaderiaelcoste.model.SaleDetail;
import com.example.panaderiaelcoste.service.SaleService;
import com.example.panaderiaelcoste.validations.SaleValidation;

import java.util.ArrayList;

public class SaleImp implements SaleService {

    ArrayList<Sale> sales = new ArrayList<>();

    @Override
    public ArrayList<Sale> getSales(){
        return sales;
    }
    @Override
    public void addSale(Employee employee, ArrayList<SaleDetail> saleDetails) throws SaleException {

        SaleValidation.verifyItemAmount(saleDetails);
        sales.add(new Sale(employee,saleDetails));
        decrementUnities(saleDetails);
        employee.setItemsSold(employee.getItemsSold()+1);


    }

    public void decrementUnities(ArrayList<SaleDetail> saleDetails){
        for (SaleDetail saleDetail : saleDetails){
            saleDetail.setAmount(saleDetail.getProduct().getAvaibleAmount()-saleDetail.getAmount());
        }
    }
}
