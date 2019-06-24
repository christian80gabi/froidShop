package com.froidShop.dao;

import com.froidShop.beans.Product;

import java.util.List;

public interface ProductDao {
    String addProduct (Product product);

    List getProducts ();
}
