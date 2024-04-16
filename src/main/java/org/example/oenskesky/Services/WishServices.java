package org.example.oenskesky.Services;

import org.example.oenskesky.Models.Wish;
import org.example.oenskesky.Repositories.WishRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WishServices {

    @Autowired
    private WishRepository wishRepository;

    public void addWish(String url, String description, String comment, int price, String wishlistId){
        wishRepository.addWish(url, description, comment, price, wishlistId);
    }

    public List<Wish> getWishes(String wishlistId){
        return wishRepository.getWishes(wishlistId);
    }

    public String checkIfWishIdIsNull(String id) {
        return wishRepository.getMaxWishId(id);
    }

    public void addEmail(String email, String id) {
        wishRepository.addEmail(email, id);
    }
}
