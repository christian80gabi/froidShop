package com.froidShop.controllers;

import com.froidShop.dao.AdminDaoImpl;
import com.froidShop.service.AdminService;
import com.froidShop.service.ServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "LoginAdmin")
public class LoginAdmin extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // session
        HttpSession session = request.getSession();
        session.setAttribute("username", username);
        session.setAttribute("password", password);

        System.out.println(username + " :: " + password);
        String page = "login_admin.jsp";

        if(username != null && password != null){
            AdminService loginService = new ServiceImpl();
            boolean flag = loginService.loginAdmin(username, password);

            if(flag){
                System.out.println("Login success !!!");
                request.setAttribute("username", username);
                request.setAttribute("message", "Login Success...");
                page = "admin_home.jsp";
            }else {
                request.setAttribute("message", "Wrong username or password, Please try again !!!");
            }
        }else {
            request.setAttribute("message", "Please enter username and password");
        }
        request.getRequestDispatcher(page).include(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("login_admin.jsp");
    }
}
