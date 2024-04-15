package org.example.oenskesky.Controllers;
import org.example.oenskesky.Services.WishServices;
import org.example.oenskesky.Services.WishlistServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class IndexController {

    @Autowired
    WishlistServices wishlistServices;
    @Autowired
    WishServices wishServices;

    @GetMapping("/")
    public String index(Model model) {
        return "/index";
    }

    @PostMapping("/createwishlist")
    public String createWishlist(){
        wishlistServices.createNewWishlist();
        int id = wishlistServices.getId();
        return "redirect:/" + id;
    }

    //The part in brackets below is called a URI ("Uniform Resource Identifier.")
    //It maps the incoming HTTP Request to a controller.
    //It specifies the URI patterns that the controller method can handle.
    //URL ("Uniform Resource Locator") is a subgroup of URI.
    @GetMapping("/{id}")
    public String showWishlist(@PathVariable int id, Model model) {
       if (wishlistServices.getPasswordViewed(id).contains("false")){
           model.addAttribute("password", wishlistServices.getPassword(id));
           //changes "password_viewed" column from 'false' to 'true'
           wishlistServices.passwordHasBeenViewed(id);
       }
        model.addAttribute("wish", wishServices.getWishes(id));
        return "/view";
    }

    @PostMapping("/{id}")
        public String redirectToWishForm(@PathVariable int id){
        return "redirect:/createawish/" + id;
    }

    @GetMapping("/createawish/{id}")
        public String displayWishForm(@PathVariable int id) {
        return "/createawish";
    }

    @PostMapping("/createawish/{id}")
        public String createWish(@PathVariable int id/*, @RequestParam("URL") String url, @RequestParam("Wish name") String description, @RequestParam("Comments") String comment, @RequestParam int price*/) {
        return "redirect:/" + id;
    }
}
