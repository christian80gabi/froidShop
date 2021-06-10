package com.froidShop.dao;

import com.froidShop.beans.Customer;

public interface CustomerDao {
    boolean login (String email, String password);

    String register (Customer customer);
}
