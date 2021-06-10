package com.froidShop.dao;

import com.froidShop.beans.Category;

import java.util.List;

public interface CategoryDao {
    String addCategory (Category category);

    List listCategory ();
}
