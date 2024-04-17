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

    public void addWish(String url, String description, String comment, int price, String wishListStringId){
        wishRepository.addWish(url, description, comment, price, wishListStringId);
    }

    public Wish getWish(int wishIntegerId){
        return wishRepository.getWish(wishIntegerId);
    }

    public List<Wish> getWishes(String wishListStringId){
        return wishRepository.getAllWishes(wishListStringId);
    }

    public String validateIfWishIdIsNull(String wishListStringId) {
        return wishRepository.getLatestWishIdFromWishListId(wishListStringId);
    }

    public void validateStringIdAndWishIntegerIdMatch(String wishListStringId, int wishIntegerId) {
        wishRepository.getwishListStringIdAndVerify(wishListStringId, wishIntegerId);
    }

    public void addEmail(String userEmail, int wishId) {
        wishRepository.addEmailToWish(userEmail, wishId);
    }

    public void updateWish(String url, String description, String comment, int price, int wishIntegerId){
        wishRepository.updateWish(url, description, comment, price, wishIntegerId);
    }

    public void deleteWish(int wishIntegerId){
        wishRepository.deleteWish(wishIntegerId);
    }
}
