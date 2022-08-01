package project.controller;

import lombok.SneakyThrows;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import project.model.User;
import project.service.UserService;
import project.util.Loginhandler;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.security.Principal;
import java.util.List;
import java.util.Map;

@Controller
public class LoginControler {
    @Autowired
    private UserService userService;
    @GetMapping("/login")
    public String getloginpage(Model model) {
        User user=new User();
        model.addAttribute("user",user);
        return "/login.html";
    }



    @SneakyThrows
    @PostMapping("login")
    public String checklogin(@ModelAttribute("user") User user){




        if(userService.checkIfUserInData(user)){
            Loginhandler.addUserToText(user);
            return "redirect:/";
        }
        else {
            return "error_page";
        }








    }
}
