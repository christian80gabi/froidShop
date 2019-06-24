package com.froidShop.dao;

import com.froidShop.beans.Customer;
import com.froidShop.hibernate.HibernateUtil;
import org.hibernate.Session;

public class CustomerDaoImpl implements CustomerDao {
    @Override
    public boolean login(String email, String password) {
        Session session = HibernateUtil.getSession();
        if (session != null){
            try {
                Customer customer = session.get(Customer.class, email);
                if (password.equals(customer.getPassword())){
                    System.out.println("Customer: " + customer.toString() + "\n" + customer.getPassword() );
                    return true;
                }
            }catch (Exception e){
                System.out.println("Exception while reading customer data: " + e.getMessage());
                return false;
            }
        }else {
            System.out.println("BD server down...");
        }
        return false;
    }

    @Override
    public String register(Customer customer) {
        String message = "Registration unsuccessful, try again...";
        Session session = HibernateUtil.getSession();
        if (session != null){
            try {
                if (customer != null){
                    String nom = (String) session.save(customer);
                    session.beginTransaction().commit();
                    message = "Customer: " + nom + "created successful, please login...";
                }
            }catch (Exception e){
                System.out.println("Exception while reading customer data: " + e.getMessage());
            }
        }else {
            System.out.println("BD server down...");
        }

        System.out.println("message: " + message);
        return message;
    }
}
