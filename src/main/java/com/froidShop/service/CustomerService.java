package com.froidShop.service;

import com.froidShop.beans.Customer;

public interface CustomerService {
    boolean loginCustomer (String mail, String password);

    String registrationCustomer(Customer customer);
}
