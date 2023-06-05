package project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import project.service.BasketService;
import project.util.MainPageHandler;

import java.io.FileNotFoundException;

@Controller
public class CartControler {
    @Autowired
    BasketService basketService;
    @GetMapping("/cart")
    public String cartPage(Model model) throws FileNotFoundException {
        if (MainPageHandler.checkIfFileClear()) {
            model.addAttribute("flag", "userloggedin");
            model.addAttribute("userproducts",basketService.getUserProducts());
        }

        else{
            model.addAttribute("flag","userNotloggedin");
        }


        return "koszyk";
    }
}
