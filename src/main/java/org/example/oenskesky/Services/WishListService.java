package org.example.oenskesky.Services;

import org.example.oenskesky.Repositories.WishListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class WishListService {

    @Autowired
    private WishListRepository wishlistRepository;

    public void createNewWishList() {
        wishlistRepository.createNewWishlistInDb(UUID.randomUUID().toString(), UUID.randomUUID().toString());
    }

    public String createWishListAndReturnStringId(){
        createNewWishList();
        return getLatestIntegerIdFromDbAndReturnItsStringId();
    }
    public String getWishListStringIdFromWishListPassword(String wishListPassword){
        return wishlistRepository.getWishListStringIdFromWishListPassword(wishListPassword);
    }

    public String getLatestIntegerIdFromDbAndReturnItsStringId() {
        int wishlistLatestIntegerId = wishlistRepository.getLatestIntegerId();
        return getStringIdForIntegerId(wishlistLatestIntegerId);
    }

    public int getIntegerIdForStringId(String wishListStringId) {
        return wishlistRepository.getIntegerIdWhereStringId(wishListStringId);
    }

    public String getStringIdForIntegerId(int wishListIntegerId) {
        return wishlistRepository.getStringIdWhereIntegerId(wishListIntegerId);
    }

    public String getWishListPassword(String wishListStringId) {
        return wishlistRepository.getWishListPasswordFromStringId(wishListStringId);
    }

    public String validateStringIdAndWishListIntegerMatch(String wishListStringId, int wishListIntegerId) {
        // If the wishListStringId and wishListIntegerId do not match, this method throws an exception
        return wishlistRepository.getIdAndVerify(wishListStringId, wishListIntegerId);
    }

    public void deleteWishList(String wishListStringId) {
        wishlistRepository.deleteWishList(wishListStringId);
    }
}
