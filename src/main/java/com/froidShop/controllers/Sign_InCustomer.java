package com.froidShop.controllers;

import com.froidShop.service.CustomerService;
import com.froidShop.service.ServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "Sign_InCustomer")
public class Sign_InCustomer extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String mail = request.getParameter("email");
        String password = request.getParameter("password");

        //session
        HttpSession session = request.getSession();
        session.setAttribute("emailCustomer", mail);
        session.setAttribute("passwordCustomer", password);

        System.out.println(mail + " :: " + password);
        String page = "sign_in.jsp";

        if (mail != null && password != null){
            CustomerService customerService = new ServiceImpl();
            boolean flag = customerService.loginCustomer(mail, password);

            if (flag){
                System.out.println("Login success !!!");
                request.setAttribute("username", mail);
                request.setAttribute("message", "Login Success...");
                page = "admin_home.jsp";
            }else {
                request.setAttribute("message", "Wrong Email or Password, Please try again...");
            }
        }else {
            request.setAttribute("message", "Please enter Email and password");
        }
        request.getRequestDispatcher(page).include(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("sign_in.jsp");
    }
}
