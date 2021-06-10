package com.froidShop.controllers;

import com.froidShop.service.ProductService;
import com.froidShop.service.ServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "Product_Controller")
public class Product_Controller extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String page = "product_manager.jsp";

        ProductService service = new ServiceImpl();
        List products = service.listProducts();

        request.setAttribute("products", products);
        request.getRequestDispatcher(page).include(request, response);
    }
}
