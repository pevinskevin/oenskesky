package org.example.oenskesky.Controllers;

import org.example.oenskesky.Services.WishServices;
import org.example.oenskesky.Services.WishlistServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class WishlistController {

    @Autowired
    WishlistServices wishlistServices;
    @Autowired
    WishServices wishServices;

    @GetMapping("/{id}")
    public String showWishlist(@PathVariable int id, Model model) {
        if (wishlistServices.getPasswordViewed(id).contains("false")){
            model.addAttribute("password", wishlistServices.getPassword(id));
            //changes "password_viewed" column from 'false' to 'true'
            wishlistServices.passwordHasBeenViewed(id);
        }
        model.addAttribute("wishId", wishServices.checkIfWishIdIsNull(id));
        model.addAttribute("wish", wishServices.getWishes(id));
        return "/view";
    }

    @PostMapping("/{id}")
    public String redirectToWishForm(@PathVariable int id){
        return "redirect:/createawish/" + id;
    }
}
