package org.example.oenskesky.Controllers;

import org.example.oenskesky.Models.Wish;
import org.example.oenskesky.Services.WishServices;
import org.example.oenskesky.Services.WishlistServices;
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


    @GetMapping("/createawish/{id}")
    public String displayWishForm(@PathVariable int id, Model model) {
        model.addAttribute("wish", new Wish());
        return "/createawish";
    }

    @PostMapping("/createawish/{id}")
    public String createWish(@PathVariable int id, @ModelAttribute("wish") Wish wish) {
        wishServices.addWish(wish.getUrl(), wish.getDescription(), wish.getComment(), wish.getPrice(), id);
        return "redirect:/" + id;
    }
}
