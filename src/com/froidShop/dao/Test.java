package com.froidShop.dao;

import com.froidShop.beans.Devise;
import com.froidShop.service.DeviseService;
import com.froidShop.service.ServiceImpl;

public class Test {
    public static void main(String[] args){
        DeviseService service = new ServiceImpl();

        String message = service.updateDevise("DTN");
        System.out.println("Update : " + message + "\n\n");

        Devise devise = service.getDevise();

        System.out.println(devise.toString());
        System.out.println("Value : " + devise.getDevise());


    }
}
