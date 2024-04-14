package org.example.oenskesky.Models;

public class Wishlist {
    private int id;
    private String password;

    public Wishlist(String password) {
        this.password = password;
    }
    public int getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }
}
