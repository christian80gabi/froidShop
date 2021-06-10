package com.froidShop.service;

import com.froidShop.beans.Devise;

public interface DeviseService {
    Devise getDevise ();

    String updateDevise (String description);
}
