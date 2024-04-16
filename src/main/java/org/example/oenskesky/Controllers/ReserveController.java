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

    @GetMapping("/{id}/{intId}/reservegift/{wishId}")
    public String reserveView(@PathVariable String id, @PathVariable Integer intId, @PathVariable Integer wishId, Model model){
        model.addAttribute("wish", new Wish());
        return "reserve";
    }

    @PostMapping("/{id}/{intId}/reservegift/{wishId}")
    public String reserveGift(@PathVariable String id, @PathVariable Integer intId, Integer wishId, @RequestParam("giftId") Integer giftId, @ModelAttribute("wish") Wish wish) {
        wishServices.addEmail(wish.getEmail(), giftId);
        return "redirect:/{id}/{intId}";
    }
}
