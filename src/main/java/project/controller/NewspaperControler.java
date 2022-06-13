package project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NewspaperControler {
    @GetMapping("/newspaper")
    public String newspaperPage() {
        return "Newspaper";
    }
}
