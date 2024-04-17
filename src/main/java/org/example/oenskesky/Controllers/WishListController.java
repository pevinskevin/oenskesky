package org.example.oenskesky.Controllers;

import org.example.oenskesky.Services.WishService;
import org.example.oenskesky.Services.WishListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.UUID;

@Controller
public class WishListController {

    @Autowired
    WishListService wishListService;
    @Autowired
    WishService wishService;

    @GetMapping("/{wishListStringId}")
    public String showWishlist(@PathVariable String wishListStringId,
                               Model model) {

        //Hides password after being displayed once one webpage.
        if (wishListService.getIsWishListPasswordViewed(wishListStringId).contains("false")) {
            model.addAttribute("password", wishListService.getWishListPassword(wishListStringId));
            wishListService.markPasswordAsViewed(wishListStringId);
        }
        //Hides wish column if there are no wish id's in database.
        int nullValue;
        if (((wishService.checkIfWishIdIsNull(wishListStringId)) == null)) {
            nullValue = 0;
            model.addAttribute("wishId", nullValue);
        } else model.addAttribute("wishId", Integer.parseInt(wishService.checkIfWishIdIsNull(wishListStringId)));
        model.addAttribute("wish", wishService.getWishes(wishListStringId));
        return "/view";
    }

    @PostMapping("/{wishListStringId}")
    public String redirectToWishForm(@PathVariable String wishListStringId) {
        return "redirect:/createawish/" + wishListStringId + "/" + wishListService.getIntegerIdForStringId(wishListStringId);
    }

    @PostMapping("/{wishListStringId}/createsharelink")
    public String createShareLink(@PathVariable String wishListStringId) {
        int intId = wishListService.getIntegerIdForStringId(wishListStringId);
        return "redirect:/" + wishListStringId + "/" + intId;
    }
}
