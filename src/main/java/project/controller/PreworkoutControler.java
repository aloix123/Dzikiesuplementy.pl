package project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import project.model.Cart;
import project.service.CartService;
import project.service.ClientService;
import project.service.PreWorkoutService;
import project.util.MainPageHandler;

import java.io.FileNotFoundException;

@Controller
public class PreworkoutControler {

    @Autowired
    PreWorkoutService presservice;
    @Autowired
    CartService cartService;
    @Autowired
    ClientService clientService;
    @GetMapping("/preworkout")
    public String preworkoutPage(Model model) {
        if (MainPageHandler.checkIfFileClear()) {
            model.addAttribute("flag", "userloggedin");
        }

        else{
            model.addAttribute("flag","userNotloggedin");
        }
        System.out.println(presservice.getPreWorkouts());
        model.addAttribute("prework",presservice.getPreWorkouts());
        return "Preworkout";

    }

    @GetMapping("addpre/{id}")
    public String addcreatine(@PathVariable(value = "id") long id, Model model) throws FileNotFoundException {
        Cart cart = new Cart((int) id, (long) clientService.getclientid());
        cartService.saveCart(cart);

        if (MainPageHandler.checkIfFileClear()) {
            model.addAttribute("flag", "userNotloggedin");
        }

        else{
            model.addAttribute("flag","userloggedin");
        }
        System.out.println(presservice.getPreWorkouts());
        model.addAttribute("prework",presservice.getPreWorkouts());
        return "redirect:/preworkout";
    }
}
