package com.froidShop.controllers;

import com.froidShop.beans.Customer;
import com.froidShop.dao.CustomerDao;
import com.froidShop.service.CustomerService;
import com.froidShop.service.ServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Sign_upCustomer")
public class Sign_upCustomer extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String message = "Password and Confirm Password must be same";
        String page = "sign_up.jsp";

        if (request.getParameter("password").equals(request.getParameter("confPassword"))){
            Customer customer = new Customer();

            customer.setPrenom(request.getParameter("prenom"));
            customer.setNom(request.getParameter("nom"));
            customer.setMail(request.getParameter("email"));
            customer.setPassword(request.getParameter("password"));
            customer.setTel(Integer.parseInt(request.getParameter("tel")));

            System.out.println(customer.toString());

            CustomerService customerService = new ServiceImpl();
            message = customerService.registrationCustomer(customer);
            page = "sign_in.jsp";
        }

        request.setAttribute("message2", message);
        request.getRequestDispatcher(page).include(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("sign_up.jsp");
    }
}
