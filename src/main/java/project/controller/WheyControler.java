package project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WheyControler {
    @GetMapping("/whey")
    public String wheyPage() {
        return "Whey";
    }

}
