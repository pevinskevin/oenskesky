package org.example.oenskesky.Controllers;

import org.example.oenskesky.Models.Wish;
import org.example.oenskesky.Services.WishListService;
import org.example.oenskesky.Services.WishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ReserveController {

    @Autowired
    WishService wishService;
    @Autowired
    WishListService wishListService;

    @GetMapping("/{wishListPassword}/reservegift/{wishIntegerId}")
    public String displayReserveWishForm(@PathVariable String wishListPassword,
                                         @PathVariable int wishIntegerId,
                                         Model model) {

        String wishListStringId = wishListService.getWishListStringIdFromWishListPassword(wishListPassword);
        wishService.validateStringIdAndWishIntegerIdMatch(wishListStringId, wishIntegerId);
        model.addAttribute("wish", new Wish());
        return "reserve";
    }

    @PostMapping("/{wishListStringId}/reservegift/{wishIntegerId}")
    public String reserveWish(@PathVariable String wishListStringId,
                              @PathVariable int wishIntegerId,
                              @ModelAttribute("wish") Wish wish) {

        wishService.addEmail(wish.getEmail(), wishIntegerId);
        return "redirect:/sharedlist/{wishListStringId}";
    }
}
