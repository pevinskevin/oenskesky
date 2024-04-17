package org.example.oenskesky.Controllers;

import org.example.oenskesky.Models.Wish;
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
public class WishListController {

    @Autowired
    WishListService wishListService;
    @Autowired
    WishService wishService;

    @GetMapping("/{wishListStringId}")
    public String showWishList(@PathVariable String wishListStringId,
                               Model model) {

        int nullValue;
        if (((wishService.validateIfWishIdIsNull(wishListStringId)) == null)) {
            nullValue = 0;
            model.addAttribute("wishId", nullValue);
        } else {model.addAttribute("wishId", Integer.parseInt(wishService.validateIfWishIdIsNull(wishListStringId)));
            }
        model.addAttribute("wish", wishService.getWishes(wishListStringId));
        return "view";
    }

    @PostMapping("/{wishListStringId}")
    public String redirectToCreateAWishPage(@PathVariable String wishListStringId) {
        int wishListIntegerId = wishListService.getIntegerIdForStringId(wishListStringId);
        return String.format("redirect:/createawish/%s/%d", wishListStringId, wishListIntegerId);
    }

    @PostMapping("/{wishListStringId}/createsharelink")
    public String redirectToShareableWishList(@PathVariable String wishListStringId) {

        String wishListPassword = wishListService.getWishListPassword(wishListStringId);
        return String.format("redirect:/sharedlist/%s", wishListPassword);
    }

    @PostMapping("/{wishListStringId}/editwish")
    public String editWish(@PathVariable String wishListStringId,
                           @RequestParam("wishIntegerId") int wishIntegerId,
                           Model model) {

       Wish wish = wishService.getWish(wishIntegerId);
        model.addAttribute("wish", wish);

        int wishListIntegerId = wishListService.getIntegerIdForStringId(wishListStringId);
        return "redirect:/{wishListStringId}/" + wishListIntegerId + "/editwish/" + wishIntegerId;
    }

    @PostMapping("/{wishListStringId}/deletewish")
    public String deleteWish(@PathVariable String wishListStringId,
                             @RequestParam("wishIntegerId") int wishIntegerId,
                             Model model) {

        Wish wish = wishService.getWish(wishIntegerId);
        model.addAttribute("wish", wish);
        wishService.deleteWish(wishIntegerId);
        return "redirect:/{wishListStringId}";
    }

    @PostMapping("/{wishListStringId}/deletewishlist")
    public String deleteWishList(@PathVariable String wishListStringId) {

        wishListService.deleteWishList(wishListStringId);
        return "redirect:/";
    }
}
