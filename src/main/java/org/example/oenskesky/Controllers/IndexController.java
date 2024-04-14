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
    WishServices wishServices;

    @GetMapping("/")
    public String index(Model model) {
        return "/index";
    }

    @PostMapping("/createwishlist")
    public String newWebPage(){
        wishlistServices.createNewWebpage();
        Integer id = wishlistServices.getId();
        return "redirect:/" + id;
    }

    @GetMapping("/{id}")
    public String newWebPageWithId(@PathVariable int id, Model model) {
       String passwordViewed = wishlistServices.getPasswordViewed(id);
       if (passwordViewed.contains("false")){
           String password = wishlistServices.getPassword(id);
           model.addAttribute("password", password);
           wishlistServices.passwordHasBeenViewed(id);
       }
       model.addAttribute("wish", wishServices.getWishes(id));
       return "/view";
    }

    @PostMapping("/createwishbutton")
    public String postMethod(){
    return "redirect:/createawish";
    }

    @GetMapping("/createawish")
    public String displayWishCreator() {
        return "/createawish";
    }

    @PostMapping("/createawishform")
    public String createAWish(@RequestParam("URL") String url, @RequestParam("Wish name") String description, @RequestParam("Comments") String comment, @RequestParam int price) {
        return "redirect:/";
    }
}
