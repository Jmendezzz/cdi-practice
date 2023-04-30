package com.example.panaderiaelcoste.controller;

import com.example.panaderiaelcoste.exception.LoginException;
import com.example.panaderiaelcoste.service.ServiceManager;
import com.example.panaderiaelcoste.singleton.Singleton;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;


@WebServlet(name = "loginAuth",value = "/login-authentication")
public class LoginController extends HttpServlet {
    ServiceManager serviceManager = Singleton.getInstance(); // Obtengo la instancia que contiene todos los servicios


    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException{

        String userName = request.getParameter("username");
        String password = request.getParameter("password");
        HttpSession session = request.getSession();
        session.removeAttribute("error");
        session.removeAttribute("status");

        try {

            setSendRedirect(userName,password,session,response,request);

        } catch (LoginException e) {
            session.setAttribute("error","Debe completar todos los campos para el inicio de sesión!");
            response.sendRedirect("index.jsp");
            System.out.println(e.getMessage());
        }

    }

    public void setSendRedirect(String userName, String password,HttpSession session,HttpServletResponse response,HttpServletRequest request) throws LoginException, IOException {

        if(serviceManager.getLoginService().verifyAdminLoginCredentials(userName,password)) {

            response.sendRedirect("admin.jsp");

        }else if (serviceManager.getLoginService().verifyEmployeeLoginCredentials(userName, password)) {

            response.sendRedirect("employee.jsp");

            request.getSession().setAttribute("employeeName",serviceManager.getLoginService().getEmployeeLoggedIn().getName());



        } else {

            session.setAttribute("status", "failed");

            response.sendRedirect("index.jsp");
        }

    }

}
