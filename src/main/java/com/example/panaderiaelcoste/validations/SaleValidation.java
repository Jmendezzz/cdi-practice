package com.example.panaderiaelcoste.validations;

import com.example.panaderiaelcoste.exception.SaleException;
import com.example.panaderiaelcoste.model.SaleDetail;

import java.util.ArrayList;

public class SaleValidation {

    public static void verifyItemAmount(ArrayList<SaleDetail> saleDetails) throws SaleException {

        for(SaleDetail saleDetail : saleDetails){
            if(saleDetail.getProduct().getAvaibleAmount() - saleDetail.getAmount() <0){
                throw new SaleException("El articulo " + saleDetail.getProduct().getName() + " no cuenta con las unidades disponibles para la venta.");
            }
        }

    }
}
