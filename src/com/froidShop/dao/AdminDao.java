package com.froidShop.dao;

import com.froidShop.beans.Admin;

public interface AdminDao {
    boolean login(String username, String password);

    String addAdmin(Admin admin);
}
