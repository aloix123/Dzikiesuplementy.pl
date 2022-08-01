package project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import project.service.ClientService;
import project.util.MainPageHandler;
import project.util.UserFileHandler;


@Controller
public class ClientController {



    @Autowired
    private ClientService clientService;

    @GetMapping("/")
    public String viewHomePage(Model model) {
        if (MainPageHandler.checkIfFileClear()){
            model.addAttribute("flag","userloggedin");
            model.addAttribute("username", "Witaj "+UserFileHandler.getUserName());
        }
        else{
            model.addAttribute("flag","userNotloggedin");
        }

        return "home.html";
    }

    @GetMapping("/error")
    public String viewErrorPage() {
        return "error_page.html";
    }


















}
