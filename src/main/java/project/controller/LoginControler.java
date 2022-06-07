package project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class LoginControler {
    @GetMapping("/login")
    public String login(Principal principal) {
        if (principal != null) {
            return "redirect:/index.html";
        }
        return "/login_page.html";
    }
}