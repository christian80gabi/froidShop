package com.froidShop.controllers;

import com.froidShop.beans.Cart;
import com.froidShop.beans.Devise;
import com.froidShop.beans.Product;
import com.froidShop.dao.CartDao;
import com.froidShop.dao.CartDaoImpl;
import com.froidShop.service.DeviseService;
import com.froidShop.service.ProductService;
import com.froidShop.service.ServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "Cart_Controller")
public class Cart_Controller extends HttpServlet {

    private CartDaoImpl cart = new CartDaoImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String page = "cart.jsp";
        System.out.println("Cart Items : " + cart.getItems());

        DeviseService deviseService = new ServiceImpl();
        Devise devise = deviseService.getDevise();

        String monaie = devise.getDevise();
        System.out.println("La devise est: " + monaie);

        request.setAttribute("cartList", cart.getItems());
        request.setAttribute("monaie", monaie);

        request.getRequestDispatcher(page).forward(request, response);
    }
}
