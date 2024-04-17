package org.example.oenskesky.Services;

import org.example.oenskesky.Models.Wish;
import org.example.oenskesky.Repositories.WishRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WishService {

    @Autowired
    private WishRepository wishRepository;

    public void addWish(String url, String description, String comment, int price, String wishlistId){
        wishRepository.addWish(url, description, comment, price, wishlistId);
    }

    public List<Wish> getWishes(String wishlistId){
        return wishRepository.getAllWishes(wishlistId);
    }

    public String checkIfWishIdIsNull(String id) {
        return wishRepository.getLatestWishIdFromWishListId(id);
    }

    public void addEmail(String email, int id) {
        wishRepository.addEmailToWish(email, id);
    }

    public void validateStringIdAndWishIntegerIdMatch(String wishListStringId, int wishIntegerId) {
        wishRepository.getwishListStringIdAndVerify(wishListStringId, wishIntegerId);
    }
}
