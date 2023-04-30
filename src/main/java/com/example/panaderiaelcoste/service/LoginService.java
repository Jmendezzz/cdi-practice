package com.example.panaderiaelcoste.service;

import com.example.panaderiaelcoste.exception.LoginException;
import com.example.panaderiaelcoste.model.Employee;

public interface LoginService {

    boolean verifyEmployeeLoginCredentials(String username, String password) throws LoginException;

    boolean verifyAdminLoginCredentials(String username, String password) throws LoginException;

    Employee getEmployeeLoggedIn();
}
