package org.example.oenskesky.Controllers;

import org.example.oenskesky.Services.WishService;
import org.example.oenskesky.Services.WishListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class IndexController {

    @Autowired
    WishListService wishListService;
    @Autowired
    WishService wishService;


    //The part in brackets below is called a URI ("Uniform Resource Identifier.")
    //It maps the incoming HTTP Request to a controller.
    //It specifies the URI patterns that the controller method can handle.
    //URL ("Uniform Resource Locator") is a subgroup of URI.
    @GetMapping("/")
    public String index(Model model) {
        return "index";
    }

    @PostMapping("/createawishlist")
    public String createWishlist() {
        return "redirect:/" + wishListService.createWishListAndReturnStringId();
    }
}
