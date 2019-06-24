package com.froidShop.dao;

import com.froidShop.beans.Devise;

public interface DeviseDao {
    Devise getDevise ();

    String updateDevise (String description);
}
