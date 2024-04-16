package org.example.oenskesky.Services;

import org.example.oenskesky.Repositories.WishlistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static org.example.oenskesky.Services.PasswordGenerator.generateRandomPassword;
import static org.example.oenskesky.Services.RandomIDGenerator.generateRandomID;

@Service
public class WishlistServices {

    @Autowired
    private WishlistRepository wishlistRepository;

    public void createNewWishlist() {
        wishlistRepository.createNewWishlistInDb(generateRandomID(30), generateRandomPassword(12));
    }

    public int getIntId() {
        return wishlistRepository.getWishlistIntId();
    }

    public int getIntIdWhereIdEquals(String id) {
        return wishlistRepository.getWishIntIdWhereIdEquqls(id);
    }

    public String getId(int intId) {
        return wishlistRepository.getWishlistId(intId);
    }

    public String getPassword(String id) {
        return wishlistRepository.getWishlistPassword(id);
    }

    public String getPasswordViewed(String id) {
       return wishlistRepository.getPasswordViewed(id);
    }

    public void passwordHasBeenViewed(String id) {
        wishlistRepository.updatePasswordViewed("true", id);
    }

    public String causeErrorIfNoMatch(String id, int intId) {
        return wishlistRepository.causeErrorIfNoMatch(id, intId);
    }
}
