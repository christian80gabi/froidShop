package com.froidShop.service;

import com.froidShop.beans.Product;

import java.util.List;

public interface ProductService {
    String addProduct(Product product);

    List listProducts ();
}
