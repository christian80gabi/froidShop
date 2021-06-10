package com.froidShop.dao;

import com.froidShop.beans.Category;
import com.froidShop.hibernate.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class CategoryDaoImpl implements CategoryDao {
    @Override
    public String addCategory(Category category) {
        String message = "Adding category unsuccessful, try again...";
        Session session = HibernateUtil.getSession();
        if (session != null){
            try {
                if (category != null){
                    String cat = (String) session.save(category);
                    session.beginTransaction().commit();
                    message = "Category: " + cat + " created successful...";
                }
            }catch (Exception e){
                System.out.println("Exception while reading category data: " + e.getMessage());
            }
        }else {
            System.out.println("BD server down...");
        }

        System.out.println("message: " + message);
        return message;
    }

    @Override
    public List listCategory() {
        List list = null;
        Session session = HibernateUtil.getSession();

        if (session != null){
            try {
                Transaction transaction = session.beginTransaction();
                String query = "select name from Category";
                Query query1 = session.createQuery(query);
                list = query1.list();
                transaction.commit();
            }catch (Exception e){
                System.out.println("Exception while access to categories data " + e.getMessage());
            }
        }else {
            System.out.println("Server down for reading categories data...");
        }
        return list;
    }
}
