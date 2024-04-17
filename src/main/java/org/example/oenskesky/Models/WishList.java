package org.example.oenskesky.Models;

import org.springframework.stereotype.Component;

@Component
public class WishList {
    private String id;
    private String password;

    public WishList() {
    }

    public String getId() {
        return id;
    }
    public String getPassword() {
        return password;
    }
}
