package com.froidShop.controllers;

import com.froidShop.beans.Devise;
import com.froidShop.hibernate.HibernateUtil;
import com.froidShop.service.DeviseService;
import com.froidShop.service.ServiceImpl;
import org.hibernate.Session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AdminHome_Controller")
public class AdminHomeController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // update devise
        String description = request.getParameter("devise");
        DeviseService deviseService = new ServiceImpl();
        deviseService.updateDevise(description);

        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String page = "admin_home.jsp";
        request.getRequestDispatcher(page).include(request, response);
    }
}
