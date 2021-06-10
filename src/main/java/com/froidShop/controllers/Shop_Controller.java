package com.froidShop.controllers;

import com.froidShop.beans.Cart;
import com.froidShop.beans.Devise;
import com.froidShop.beans.Product;
import com.froidShop.dao.CartDaoImpl;
import com.froidShop.service.CartService;
import com.froidShop.service.DeviseService;
import com.froidShop.service.ProductService;
import com.froidShop.service.ServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "Shop_Controller")
public class Shop_Controller extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("productIdentity"));
        System.out.println("ID is : " + id);

        CartService cartService = new ServiceImpl();
        List<Product> cartItems = cartService.addCart(id);

        CartDaoImpl dao = new CartDaoImpl();
        System.out.println("....CartDao........" + dao.getItems() +  "...............");

        System.out.println("....CartItems........" + cartItems +  "...............");

        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String page = "shop.jsp";

        ProductService service = new ServiceImpl();
        List list = service.listProducts();

        DeviseService deviseService = new ServiceImpl();
        Devise devise = deviseService.getDevise();

        String monaie = devise.getDevise();
        System.out.println("La devise est: " + monaie);

        request.setAttribute("list", list);
        request.setAttribute("monaie", monaie);

        request.getRequestDispatcher(page).forward(request, response);
    }
}
