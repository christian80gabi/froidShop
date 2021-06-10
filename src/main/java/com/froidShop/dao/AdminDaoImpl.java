package com.froidShop.dao;

import com.froidShop.beans.Admin;
import com.froidShop.hibernate.HibernateUtil;
import org.hibernate.Session;

public class AdminDaoImpl implements AdminDao {

    @Override
    public boolean login(String username, String password) {
        Session session = HibernateUtil.getSession();
        if (session != null){
            try {
                Admin admin = session.get(Admin.class, username);
                if (password.equals(admin.getPassword())){
                    System.out.println("Admin: " + admin.toString());
                    return true;
                }
            }catch (Exception e){
                System.out.println("Exception while reading admin data: " + e.getMessage());
            }
        }else {
            System.out.println("BD server down...");
        }
        return false;
    }

    @Override
    public String addAdmin(Admin admin) {
        String message = "Registration (AddAdmin) unsuccessful, try again...";
        Session session = HibernateUtil.getSession();
        if (session != null){
            try {
                if (admin != null){
                    String username = (String) session.save(admin);
                    session.beginTransaction().commit();
                    message = "Admin " + username + "created successful, you can use it now...";
                }
            }catch (Exception e){
                System.out.println("Exception while reading admin data: " + e.getMessage());
            }
        }else {
            System.out.println("BD server down...");
        }

        System.out.println("message: " + message);
        return message;
    }
}
