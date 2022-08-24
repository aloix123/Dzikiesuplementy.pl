package project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import project.util.Personalfilehandler;

import java.util.List;

@Controller
public class PersonalControler {
    @GetMapping("/personal")
    public String personalPage(Model model) {
        List<String>  parameters= Personalfilehandler.getparameters();
        model.addAttribute("adress", "Your adress is "+parameters.get(0));
        model.addAttribute("number", "Your numer is "+parameters.get(1));
        model.addAttribute("surname", "Your surname is "+parameters.get(2));
        model.addAttribute("name", "Your name is "+parameters.get(3));
        model.addAttribute("flag", "userloggedin");
        return "personal_page";
    }
}
