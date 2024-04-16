package org.example.oenskesky.Controllers;

import org.example.oenskesky.Services.WishServices;
import org.example.oenskesky.Services.WishlistServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.UUID;

@Controller
public class WishlistController {

    @Autowired
    WishlistServices wishlistServices;
    @Autowired
    WishServices wishServices;

    @GetMapping("/{wishlistId}")
    public String showWishlist(@PathVariable String wishlistId, Model model) {
        if (wishlistServices.getPasswordViewed(wishlistId).contains("false")){
            model.addAttribute("password", wishlistServices.getPassword(wishlistId));
            //changes "password_viewed" column from 'false' to 'true'
            wishlistServices.passwordHasBeenViewed(wishlistId);
        }
        int nullValue;
        if (((wishServices.checkIfWishIdIsNull(wishlistId)) == null)){
             nullValue = 0;
            model.addAttribute("wishId", nullValue);
        } else model.addAttribute("wishId", Integer.parseInt(wishServices.checkIfWishIdIsNull(wishlistId)));

        model.addAttribute("wish", wishServices.getWishes(wishlistId));
        return "/view";
    }

    @PostMapping("/{wishlistId}")
    public String redirectToWishForm(@PathVariable String wishlistId){
        return "redirect:/createawish/" + wishlistId;
    }

    @PostMapping("/{wishlistId}/createsharelink")
    public String createShareLink(@PathVariable String wishlistId) {
        int intId = wishlistServices.getIntIdWhereIdEquals(wishlistId);
        String randomString = UUID.randomUUID().toString();
        return "redirect:/" + wishlistId + "/" + intId;
    }
}
