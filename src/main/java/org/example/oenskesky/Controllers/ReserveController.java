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

    //If I don't name the PathVariables weirdly the program crashes. - No idea why.
    @GetMapping("/{wishListStringId}/{wishListIntegerId}/reservegift/{wishIntegerId}")
    public String reserveView(@PathVariable String wishListStringId,
                              @PathVariable Integer wishListIntegerId,
                              @PathVariable int wishIntegerId,
                              Model model) {

        wishListService.validateStringIdAndIntegerMatch(wishListStringId, wishListIntegerId);
        wishService.validateStringIdAndWishIntegerIdMatch(wishListStringId, wishIntegerId);
        model.addAttribute("wish", new Wish());
        return "reserve";
    }

    //If I don't name the PathVariables weirdly the program crashes. - No idea why.
    @PostMapping("/{wishListStringId}/{wishListIntegerId}/reservegift/{wishIntegerId}")
    public String reserveGift(@PathVariable String wishListStringId,
                              @PathVariable Integer wishListIntegerId,
                              @PathVariable int wishIntegerId,
                              @ModelAttribute("wish") Wish wish) {
        wishService.addEmail(wish.getEmail(), wishIntegerId);
        return "redirect:/{wishListStringId}/{wishListIntegerId}";
    }
}
