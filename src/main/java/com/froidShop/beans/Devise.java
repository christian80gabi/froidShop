package com.froidShop.beans;

public class Devise {
    private int id;
    private String devise;

    public String getDevise() {
        return devise;
    }

    public void setDevise(String devise) {
        this.devise = devise;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Devise{" +
                "id=" + id +
                ", devise='" + devise + '\'' +
                '}';
    }
}
