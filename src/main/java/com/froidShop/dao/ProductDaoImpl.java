package com.froidShop.dao;

import com.froidShop.beans.Product;
import com.froidShop.hibernate.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;


public class ProductDaoImpl implements ProductDao {
    @Override
    public List getProducts() {
        List list = null;
        Session session = HibernateUtil.getSession();

        if (session != null){
            try {
                Transaction transaction = session.beginTransaction();
                String query = "from Product";
                Query query1 = session.createQuery(query);
                list = query1.list();
                transaction.commit();

            }catch (Exception e){
                System.out.println("Exception while access to products data " + e.getMessage());
            }
        }else {
            System.out.println("Server down for reading product products data...");
        }
        return list;
    }

    @Override
    public String addProduct(Product product) {
        String message = "Adding product unsuccessful, try again...";
        Session session = HibernateUtil.getSession();

        if (session != null){
            try {
                if (product != null){
                    Integer prod = (Integer) session.save(product);
                    session.beginTransaction().commit();
                    message = "Product: " + prod + " created successful...";
                }
            }catch (Exception e){
                System.out.println("Exception while reading product data: " + e.getMessage());
            }
        }else {
            System.out.println("BD server down...");
        }

        System.out.println("message " + message);

        return message;
    }
}
