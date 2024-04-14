package org.example.oenskesky.Controllers;
import org.example.oenskesky.Services.WishlistServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class IndexController {

    @Autowired
    WishlistServices wishlistServices;

    @GetMapping("/")
    public String index(Model model) {
        return "/index";
    }

    @PostMapping("/create")
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
       };
        return "/view";

    }

}
