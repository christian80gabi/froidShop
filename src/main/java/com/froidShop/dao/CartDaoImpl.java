package com.froidShop.dao;

import com.froidShop.beans.Cart;
import com.froidShop.beans.Product;
import com.froidShop.hibernate.HibernateUtil;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

public class CartDaoImpl implements CartDao {

    private Cart cartItems = new Cart();

    @Override
    public List<Product> addCart(int id) {
        Session session = HibernateUtil.getSession();
        //ArrayList<Product> products = new ArrayList<>();
        if (session != null) {
            try {
                Product product = session.get(Product.class, id);
                System.out.println("Product : " + product + "added into the cart");
                //products.add(product);
                cartItems.addItems(product);
                System.out.println("Cart Items Before ::: Test ::: " + cartItems.getCartItems());
                //System.out.println("Cart Items Before ::: Test ::: " + products);
                session.beginTransaction().commit();
                cartItems.setCartItems(cartItems.getCartItems());
                return cartItems.getCartItems();
            } catch (Exception e) {
                System.out.println("Exception while adding this product into the cart " + e.getMessage());
            }
        } else {
            System.out.println("BD server down...");
        }
        return cartItems.getCartItems();
    }

    public List<Product> getItems(){
        return this.cartItems.getCartItems();
    }
}
