package org.example.oenskesky.Services;

import org.example.oenskesky.Repositories.WishlistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static org.example.oenskesky.Services.PasswordGenerator.generateRandomPassword;

@Service
public class WishlistServices {

    @Autowired
    private WishlistRepository wishlistRepository;

    public void createNewWishlist() {
        String randomPassword = generateRandomPassword(12);
        wishlistRepository.createNewWishlistInDb(randomPassword);
    }

    public int getId() {
        return wishlistRepository.getWishlistId();
    }

    public String getPassword(int id) {
        return wishlistRepository.getWishlistPassword(id);
    }

    public String getPasswordViewed(int id) {
       return wishlistRepository.getPasswordViewed(id);
    }

    public void passwordHasBeenViewed(int id) {
        wishlistRepository.updatePasswordViewed("true", id);
    }
}
