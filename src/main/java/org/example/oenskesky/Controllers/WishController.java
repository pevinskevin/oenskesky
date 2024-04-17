package org.example.oenskesky.Controllers;

import org.example.oenskesky.Models.Wish;
import org.example.oenskesky.Services.WishListService;
import org.example.oenskesky.Services.WishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class WishController {

    @Autowired
    WishListService wishListService;
    @Autowired
    WishService wishService;

    @GetMapping("/createawish/{wishListStringId}/{wishListIntegerId}")
    public String displayWishForm(@PathVariable String wishListStringId,
                                  @PathVariable int wishListIntegerId,
                                  Model model) {

        wishListService.validateStringIdAndWishListIntegerMatch(wishListStringId, wishListIntegerId);
        model.addAttribute("wish", new Wish());
        return "/createawish";
    }

    @PostMapping("/createawish/{WishListStringId}")
    public String createWish(@PathVariable String WishListStringId,
                             @ModelAttribute("wish") Wish wish) {

        wishService.addWish(wish.getUrl(), wish.getDescription(), wish.getComment(), wish.getPrice(), WishListStringId);
        return "redirect:/" + WishListStringId;
    }
}
