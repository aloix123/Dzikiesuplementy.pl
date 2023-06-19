package project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import project.model.Cart;
import project.model.Product;
import project.service.BasketService;
import project.service.CartService;
import project.service.ClientService;
import project.service.ProductService;
import project.util.MainPageHandler;

import java.io.FileNotFoundException;

@Controller
public class CartControler {
    @Autowired
    ClientService clientService;
    @Autowired
    CartService cartService;
    @Autowired
    ProductService productService;
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
    @GetMapping("cart/add/{id}")
    public String increaseamount(@PathVariable(value = "id") long id,Model model) throws FileNotFoundException {
        Cart cart = new Cart((int) id, (long) clientService.getclientid());
        cartService.saveCart(cart);
        if (MainPageHandler.checkIfFileClear()) {
            model.addAttribute("flag", "userloggedin");
        }

        else{
            model.addAttribute("flag","userNotloggedin");
        }
        return "redirect:/cart";

    }
    @GetMapping("cart/remove/{id}")
    public String decreseamount(@PathVariable(value = "id") long id,Model model) {

        cartService.deletCartByProductId(id);
        if (MainPageHandler.checkIfFileClear()) {
            model.addAttribute("flag", "userloggedin");
        }

        else{
            model.addAttribute("flag","userNotloggedin");
        }
        return "redirect:/cart";

    }
}
