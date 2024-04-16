package org.example.oenskesky.Models;

import org.springframework.stereotype.Component;

@Component
public class Wishlist {
    private String id;
    private String password;

    public Wishlist() {
    }

    public String getId() {
        return id;
    }
    public String getPassword() {
        return password;
    }
}
