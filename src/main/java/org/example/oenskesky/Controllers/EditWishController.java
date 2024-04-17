package org.example.oenskesky.Controllers;

import org.example.oenskesky.Models.Wish;
import org.example.oenskesky.Services.WishListService;
import org.example.oenskesky.Services.WishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class EditWishController {

    @Autowired
    WishListService wishListService;
    @Autowired
    WishService wishService;

    @GetMapping("/{wishListStringId}/{wishListIntegerId}/editwish/{wishIntegerId}")
    public String showEditWishPage(@PathVariable String wishListStringId,
                                   @PathVariable int wishListIntegerId,
                                   @PathVariable int wishIntegerId,
                                   Model model){

        wishListService.validateStringIdAndWishListIntegerMatch(wishListStringId, wishListIntegerId);
        wishService.validateStringIdAndWishIntegerIdMatch(wishListStringId, wishIntegerId);
        //model.addAttribute("wish", new Wish());
        Wish wish = wishService.getWish(wishIntegerId);
        model.addAttribute("wish", wish);
        return "/posteditedwish";
    }

    @PostMapping("/{wishListStringId}/{wishListIntegerId}/editedwish/{wishIntegerId}")
    public String postEditedWish(@PathVariable String wishListStringId,
                                 @PathVariable int wishListIntegerId,
                                 @PathVariable int wishIntegerId,
                                 @ModelAttribute("wish") Wish wish){

        wishService.updateWish(wish.getUrl(), wish.getDescription(), wish.getComment(), wish.getPrice(), wishIntegerId);
        return "redirect:/{wishListStringId}";
    }

}
