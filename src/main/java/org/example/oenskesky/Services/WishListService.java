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

    public String getLatestIntegerIdFromDbAndReturnItsStringId() {
        int integerId = wishlistRepository.getLatestIntegerId();
        return getStringIdForIntegerId(integerId);
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

    public String getIsWishListPasswordViewed(String wishListStringId) {
       return wishlistRepository.getPasswordViewedStatus(wishListStringId);
    }

    public void markPasswordAsViewed(String wishListStringId) {
        wishlistRepository.setPasswordViewed("true", wishListStringId);
    }

    public String validateStringIdAndIntegerMatch(String wishListStringId, int wishListIntegerId) {
        // If the wishListStringId and wishListIntegerId do not match, this method throws an exception
        return wishlistRepository.getIdAndVerify(wishListStringId, wishListIntegerId);
    }
}
