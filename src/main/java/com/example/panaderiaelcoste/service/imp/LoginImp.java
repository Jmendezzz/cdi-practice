package com.example.panaderiaelcoste.service.imp;
import com.example.panaderiaelcoste.exception.LoginException;
import com.example.panaderiaelcoste.model.Admin;
import com.example.panaderiaelcoste.model.Employee;
import com.example.panaderiaelcoste.service.LoginService;
import com.example.panaderiaelcoste.service.ServiceManager;

import java.util.ArrayList;


public class LoginImp implements LoginService {
    ServiceManager serviceManager;
    ArrayList<Employee> employees;

    public  Employee employeeLoggedIn;

    public LoginImp(ServiceManager serviceManager){
        this.serviceManager = serviceManager;
        employees = serviceManager.getEmployeeService().getEmployees();

    }

    @Override
    public boolean verifyEmployeeLoginCredentials(String username, String password) throws LoginException {
        if(username.equals("") || password.equals("")) throw new LoginException("Debe completar los campos");
        employeeLoggedIn= employees.stream()
                .filter(
                        employee ->  employee.getLoginCredentials().getUsername().equals(username) &&
                        employee.getLoginCredentials().getPassword().equals(password))
                .findFirst()
                .orElse(null);

        return employees.stream()
                .anyMatch(
                employee ->  employee.getLoginCredentials().getUsername().equals(username) &&
                                employee.getLoginCredentials().getPassword().equals(password)
                );

    }

    @Override
    public boolean verifyAdminLoginCredentials(String username, String password) throws LoginException {

        if(username.equals("") || password.equals("")) throw new LoginException("Debe completar los campos");
        return Admin.loginCredentials.getUsername().equals(username)
                &&
                Admin.loginCredentials.getPassword().equals(password);

    }
    @Override
    public Employee getEmployeeLoggedIn(){
        return employeeLoggedIn;
    }
}
