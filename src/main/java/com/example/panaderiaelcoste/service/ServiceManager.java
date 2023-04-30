package com.example.panaderiaelcoste.service;

import com.example.panaderiaelcoste.service.imp.EmployeeImp;
import com.example.panaderiaelcoste.service.imp.LoginImp;
import com.example.panaderiaelcoste.service.imp.ProductImp;
import com.example.panaderiaelcoste.service.imp.SaleImp;
import lombok.Getter;
import lombok.Setter;


@Getter @Setter
public class ServiceManager {

    private final  LoginService loginService;
    private final  EmployeeService employeeService;



    private final SaleService saleService;

    public ServiceManager(){
        employeeService = new EmployeeImp();
        loginService = new LoginImp(this);
        saleService = new SaleImp();


    }

}
