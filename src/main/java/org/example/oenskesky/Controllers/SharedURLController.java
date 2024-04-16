package org.example.oenskesky.Controllers;

import org.example.oenskesky.Models.Wishlist;
import org.example.oenskesky.Services.WishServices;
import org.example.oenskesky.Services.WishlistServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SharedURLController {

    @Autowired
    WishServices wishServices;
    @Autowired
    WishlistServices wishlistServices;
    @Autowired
    Wishlist wishlist;

    @GetMapping("/{id}/{intId}")
    public String sharedURL(@PathVariable String id, @PathVariable int intId, Model model) {
        wishlistServices.causeErrorIfNoMatch(id, intId);
        int nullValue;
        if (((wishServices.checkIfWishIdIsNull(id)) == null)){
            nullValue = 0;
            model.addAttribute("wishId", nullValue);
        } else model.addAttribute("wishId", Integer.parseInt(wishServices.checkIfWishIdIsNull(id)));
        model.addAttribute("wish", wishServices.getWishes(id));
        return "/sharedurlview";
    }

    @PostMapping("/{id}/{intId}")
    public String reserveWish(@PathVariable String id, @PathVariable int intId) {
        return "redirect:/{id}/{intId}/reservegift";
    }
}
