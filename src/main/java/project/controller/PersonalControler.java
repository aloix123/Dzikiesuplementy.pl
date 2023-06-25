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
        model.addAttribute("adress", parameters.get(0));
        model.addAttribute("number", parameters.get(1));
        model.addAttribute("surname", parameters.get(2));
        model.addAttribute("name", parameters.get(3));
        model.addAttribute("flag", "userloggedin");
        return "personal_page";
    }
}
