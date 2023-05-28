package project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import project.model.Cart;
import project.service.CartService;
import project.service.ClientService;
import project.service.CreatineService;
import project.util.MainPageHandler;

import javax.persistence.Access;
import java.io.FileNotFoundException;

@Controller
public class CreatineControler {
    @Autowired
    CartService cartService;
    @Autowired
    CreatineService creatineService;
    @Autowired
    ClientService clientService;
    @GetMapping("/creatine")
    public String creatinePage(Model model ){

        if (MainPageHandler.checkIfFileClear()) {
            model.addAttribute("flag", "userloggedin");
        }

        else{
            model.addAttribute("flag","userNotloggedin");
        }
        System.out.println(creatineService.getCreatines());
        model.addAttribute("creatines",creatineService.getCreatines());
        return "Creatine";
    }
    @GetMapping("addcreatine/{id}")
    public String addcreatine(@PathVariable(value = "id") long id,Model model) throws FileNotFoundException {
        Cart cart = new Cart((int) id, (long) clientService.getclientid());
        cartService.saveCart(cart);

        if (MainPageHandler.checkIfFileClear()) {
            model.addAttribute("flag", "userNotloggedin");
        }

        else{
            model.addAttribute("flag","userloggedin");
        }
        System.out.println(creatineService.getCreatines());
        model.addAttribute("creatines",creatineService.getCreatines());
        return "redirect:/creatine";
    }
}
