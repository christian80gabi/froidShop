package com.froidShop.beans;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private Integer id;
    private List<Product> cartItems;
    private double total;

    public Cart (){
        cartItems = new ArrayList<>();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Product> getCartItems() {
        return cartItems;
    }

    public void setCartItems(List<Product> cartItems) {
        this.cartItems = cartItems;
    }

    public  void addItems(Product product){
        this.cartItems.add(product);
    }

    public void removeItems(Product product){ this.cartItems.remove(product); }

    public int getNumberOfItems(){
        System.out.println(cartItems.size());
        return cartItems.size();
    }

    @Override
    public String toString() {
        return "Cart{" +
                "id=" + id +
                ", cartItems=" + cartItems +
                '}';
    }
}
