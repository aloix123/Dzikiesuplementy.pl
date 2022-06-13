package project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CreatineControler {
    @GetMapping("/creatine")
    public String creatinePage() {
        return "Creatine";
    }
}
