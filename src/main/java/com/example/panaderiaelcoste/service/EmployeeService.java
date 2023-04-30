package com.example.panaderiaelcoste.service;

import com.example.panaderiaelcoste.exception.RegisterException;
import com.example.panaderiaelcoste.model.Employee;

import java.util.ArrayList;

public interface EmployeeService {
    ArrayList<Employee> getEmployees();

    void addEmployee(String name, String id, String email) throws RegisterException;

    void deleteEmployeeById(String id);
}
