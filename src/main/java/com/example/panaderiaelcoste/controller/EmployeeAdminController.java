package com.example.panaderiaelcoste.controller;

import com.example.panaderiaelcoste.exception.RegisterException;
import com.example.panaderiaelcoste.model.Employee;
import com.example.panaderiaelcoste.service.ServiceManager;
import com.example.panaderiaelcoste.singleton.Singleton;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "emplooyeAdmin", value = "/admin-employees")
public class EmployeeAdminController extends HttpServlet {

    ServiceManager serviceManager = Singleton.getInstance();
    ArrayList<String> errors = new ArrayList<>();
    ObjectMapper objectMapper = new ObjectMapper();


    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        errors.clear();

        HttpSession session = request.getSession();
        String isDelete = request.getParameter("idDeleteEmployee");
        System.out.println(isDelete);

        String method = isDelete == null ? "POST" : "DELETE";
        System.out.println(method);

        switch (method) {
            case "POST":

                String name = request.getParameter("name");
                validateInput("name", name);
                String id = request.getParameter("id");
                validateInput("avaibleAmount", id);
                String email = request.getParameter("email");
                validateInput("email", email);


                if (!(errors.size() > 0)) {
                    try {
                        serviceManager.getEmployeeService().addEmployee(name, id, email);
                        session.removeAttribute("registerError");
                        doGet(request, response);

                    } catch (RegisterException e) {
                        session.setAttribute("registerError", e.getMessage());
                    }
                } else {
                    System.out.println("campos vacios");
                    session.setAttribute("registerError", "Debe completar todos los campos!");

                }
                break;
            case "DELETE":
                doDelete(request, response);
                doGet(request, response); //Actualizar tabla en el front
                break;

        }
        response.sendRedirect("admin-employees.jsp");

    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        System.out.println("Getting emplooyes...");

        ArrayList<Employee> employees = serviceManager.getEmployeeService().getEmployees();
        System.out.println(objectMapper.writeValueAsString(employees));

        request.getSession().setAttribute("employees", objectMapper.writeValueAsString(employees));


    }

    public void validateInput(String key, String value) {
        if (value == null || value.isEmpty()) {
            errors.add(key);
        }
    }

    @Override
    public void doDelete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("idDeleteEmployee");
        serviceManager.getEmployeeService().deleteEmployeeById(id);
    }
}
