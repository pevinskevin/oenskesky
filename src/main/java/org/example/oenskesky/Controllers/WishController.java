package org.example.oenskesky.Controllers;

import org.example.oenskesky.Models.Wish;
import org.example.oenskesky.Services.WishServices;
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
    WishServices wishServices;

    //If I don't name the PathVariable the program crashes. - No idea why.
    @GetMapping("/createawish/{wishlistId}")
    public String displayWishForm(@PathVariable String wishlistId,
                                  Model model) {
        model.addAttribute("wish", new Wish());
        return "/createawish";
    }
    //If I don't name the PathVariables weirdly the program crashes. - No idea why.
    @PostMapping("/createawish/{giftId}")
    public String createWish(@PathVariable String giftId,
                             @ModelAttribute("wish") Wish wish) {
        wishServices.addWish(wish.getUrl(), wish.getDescription(), wish.getComment(), wish.getPrice(), giftId);
        return "redirect:/" + giftId;
    }
}
