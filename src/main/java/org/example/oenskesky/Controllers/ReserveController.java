package org.example.oenskesky.Controllers;

import org.example.oenskesky.Models.Wish;
import org.example.oenskesky.Services.WishServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ReserveController {

    @Autowired
    WishServices wishServices;

    //If I don't name the PathVariables weirdly the program crashes. - No idea why.
    @GetMapping("/{id}/{intId}/reservegift/{wishId}")
    public String reserveView(@PathVariable String id,
                              @PathVariable Integer intId,
                              @PathVariable int wishId,
                              Model model){

        model.addAttribute("wish", new Wish());
        return "reserve";
    }

    //If I don't name the PathVariables weirdly the program crashes. - No idea why.
    @PostMapping("/{anotherRefactor}/{refactoredId}/reservegift/{giftId}")
    public String reserveGift(@PathVariable String anotherRefactor,
                              @PathVariable Integer refactoredId,
                              @PathVariable int giftId,
                              @ModelAttribute("wish") Wish wish){
        wishServices.addEmail(wish.getEmail(), giftId);
        return "redirect:/{anotherRefactor}/{refactoredId}";
    }
}
