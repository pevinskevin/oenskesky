package org.example.oenskesky.Models;


public class Wish {
    private int id;


    private String url;
    private String description;
    private String comment;
    private int price;
    private String email;
    private int wishlistID;

    public Wish(String url, String description, String comment, int price, String email, int wishlistID) {
        this.url = url;
        this.description = description;
        this.comment = comment;
        this.price = price;
        this.email = email;
        this.wishlistID = wishlistID;
    }

    public int getId() {
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

    public void setEmail(String email) {
        this.email = email;
    }

    public int getWishlistID() {
        return wishlistID;
    }

    public void setWishlistID(int wishlistID) {
        this.wishlistID = wishlistID;
    }
}
