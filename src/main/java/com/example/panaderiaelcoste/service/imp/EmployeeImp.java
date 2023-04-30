package com.example.panaderiaelcoste.service.imp;

import com.example.panaderiaelcoste.exception.RegisterException;
import com.example.panaderiaelcoste.model.Employee;
import com.example.panaderiaelcoste.model.LoginCredential;
import com.example.panaderiaelcoste.service.EmployeeService;

import java.util.ArrayList;


public class EmployeeImp implements EmployeeService {

    ArrayList<Employee> employees = new ArrayList<>();
    public EmployeeImp(){

        employees.add(new Employee("Juan","123","jugmeen23@gmail.com",new LoginCredential("juan","1234")));

    }


    @Override
    public ArrayList<Employee> getEmployees() {
        return employees;
    }

    @Override
    public void addEmployee(String name, String id, String email) throws RegisterException {
        verifyRepeatedId(id);
        Employee employee = new Employee(name,id,email,new LoginCredential(id,id));
        employees.add(employee);

    }
    @Override
    public void deleteEmployeeById(String id){
        Employee employee  = employees.stream()
                .filter(e->e.getId().equals(id))
                .findFirst()
                .orElse(null);

        employees.remove(employee);
    }

    void verifyRepeatedId(String id) throws RegisterException{

        if (employees.stream().anyMatch(employee -> employee.getId().equals(id))){
            throw new RegisterException("Ya existe un empleado con ese ID");
        }

    }
}

