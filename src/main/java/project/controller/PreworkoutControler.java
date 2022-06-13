package project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PreworkoutControler {
    @GetMapping("/preworkout")
    public String preworkoutPage() {
        return "Preworkout";
    }

}
