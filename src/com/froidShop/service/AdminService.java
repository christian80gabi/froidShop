package com.froidShop.service;

import com.froidShop.beans.Admin;

public interface AdminService {
    boolean loginAdmin(String username, String password);

    String addAdmin(Admin admin);
}
