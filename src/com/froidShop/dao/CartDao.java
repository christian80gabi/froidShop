package com.froidShop.dao;

import com.froidShop.beans.Product;

import java.util.List;

public interface CartDao {
    List<Product> addCart(int id);
}
