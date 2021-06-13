package com.froidShop.controllers;

import com.froidShop.beans.Category;
import com.froidShop.service.CategoryService;
import com.froidShop.service.ServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "Category_Controller")
public class CategoryController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String page = "category_manager.jsp";
        Category category = new Category();
        category.setName(request.getParameter("name"));

        System.out.println(category.toString());

        CategoryService categoryService = new ServiceImpl();
        String message = categoryService.addCategory(category);

        request.setAttribute("message", message);
        request.getRequestDispatcher(page).include(request, response);
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String page = "category_manager.jsp";
        CategoryService categoryService = new ServiceImpl();
        List categories = categoryService.listCategory();

        request.setAttribute("categories", categories);
        request.getRequestDispatcher(page).forward(request, response);
    }
}
