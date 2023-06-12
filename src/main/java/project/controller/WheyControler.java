package project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.AccessType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import project.model.Cart;
import project.service.CartService;
import project.service.ClientService;
import project.service.WheyService;
import project.util.MainPageHandler;
import org.springframework.ui.Model;

import java.io.FileNotFoundException;

@Controller
public class WheyControler {
    @Autowired
    CartService cartService;
    @Autowired
    ClientService clientService;
    @Autowired
    WheyService wheyService;
    @GetMapping("/whey")
    public String wheyPage(Model model) {
        if (MainPageHandler.checkIfFileClear()) {
            model.addAttribute("flag", "userloggedin");
        }

        else{
            model.addAttribute("flag","userNotloggedin");
        }
        System.out.println(wheyService.getproteins());
        model.addAttribute("whey",wheyService.getproteins());
        return "Whey";

    }
    @GetMapping("addwhey/{id}")
    public String addwhey(@PathVariable(value = "id") long id, Model model) throws FileNotFoundException {
        Cart cart = new Cart((int) id, (long) clientService.getclientid());
        cartService.saveCart(cart);

        if (MainPageHandler.checkIfFileClear()) {
            model.addAttribute("flag", "userNotloggedin");
        }

        else{
            model.addAttribute("flag","userloggedin");
        }
        System.out.println(wheyService.getproteins());

        return "redirect:/whey";
    }
}
