package com.froidShop.service;

import com.froidShop.beans.Product;

import java.util.List;

public interface CartService {
    List<Product> addCart(int id);
}
