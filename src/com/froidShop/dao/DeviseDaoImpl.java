package com.froidShop.dao;

import com.froidShop.beans.Devise;
import com.froidShop.hibernate.HibernateUtil;
import org.hibernate.Session;

import java.util.List;

public class DeviseDaoImpl implements DeviseDao {
    @Override
    public Devise getDevise() {
        Session session = HibernateUtil.getSession();
        Devise devise = null;

        try {
            List list = session.createQuery("from Devise").list();

            for (Object e : list){
                System.out.println(e.toString());
            }

            Object s = list.get(0);
            devise = (Devise) s;

            System.out.println("getting devise " + devise.toString() + "from database");
            session.beginTransaction().rollback();
        }catch (Exception e){
            System.out.println("Exception while getting devise from database " + e.getMessage());
        }

        return devise;
    }

    @Override
    public String updateDevise(String s) {
        String update = "issue while updating devise";
        Session session = HibernateUtil.getSession();
        if (s != null){
            try {
                Devise devise = session.load(Devise.class, 1);
                devise.setDevise(s);
                session.update(devise);

                session.beginTransaction().commit();

                System.out.println("Devise : " + devise.toString() + "was updated");
                update = "Devise : " + devise.getDevise() + " was updated";
            }catch (Exception e) {
                System.out.println("Exception while saving devise " + e.getMessage());
            }
        }
        return update;
    }
}
