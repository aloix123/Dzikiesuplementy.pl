package project.controller;

import org.springframework.web.bind.annotation.GetMapping;

public class CartControler {
    @GetMapping("/cart")
    public String cartPage() {
        return "koszyk";
    }
}
