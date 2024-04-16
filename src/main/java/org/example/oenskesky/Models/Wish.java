package org.example.oenskesky.Models;

import org.springframework.stereotype.Component;

@Component
public class Wish {
    private String id;
    private String url;
    private String description;
    private String comment;
    private int price;
    private String email;
    private String wishlistID;

    public Wish() {
    }

    public String getId() {
        return id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getEmail() {
        return email;
    }

    public String getWishlistID() {
        return wishlistID;
    }
}
