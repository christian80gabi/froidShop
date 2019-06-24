package com.froidShop.service;

import com.froidShop.beans.Category;

import java.util.List;

public interface CategoryService {
    String addCategory (Category category);

    List listCategory ();
}
