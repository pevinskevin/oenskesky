package org.example.oenskesky.Controllers;

import org.example.oenskesky.Models.WishList;
import org.example.oenskesky.Services.WishService;
import org.example.oenskesky.Services.WishListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SharedURLController {

    @Autowired
    WishService wishService;
    @Autowired
    WishListService wishListService;
    @Autowired
    WishList wishList;

    @GetMapping("/sharedlist/{wishListPassword}")
    public String showSharingWishList(@PathVariable String wishListPassword,
                                      Model model) {

        String wishListStringId = wishListService.getWishListStringIdFromWishListPassword(wishListPassword);
        int nullValue;
        if (((wishService.validateIfWishIdIsNull(wishListStringId)) == null)) {
            nullValue = 0;
            model.addAttribute("wishId", nullValue);
        } else model.addAttribute("wishId", Integer.parseInt(wishService.validateIfWishIdIsNull(wishListStringId)));
        model.addAttribute("wish", wishService.getWishes(wishListStringId));
        return "/sharedurlview";
    }

    @PostMapping("/{wishListStringId}/reservewish")
    public String reserveWish(@PathVariable String wishListStringId,
                              @RequestParam("wishIntegerId") int wishIntegerId) {

        return "redirect:/{wishListStringId}/reservegift/" + wishIntegerId;
    }
}
