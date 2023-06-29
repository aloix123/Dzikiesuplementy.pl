package project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import project.service.ClientService;
import project.util.MainPageHandler;
import project.util.UserFileHandler;

import java.io.IOException;


@Controller
public class ClientController {



    @Autowired
    private ClientService clientService;

    @GetMapping("/")
    public String viewHomePage(Model model) throws IOException {
        System.out.println(MainPageHandler.checkIfFileClear());
        if (MainPageHandler.checkIfFileClear()){
            model.addAttribute("flag","userloggedin");
            model.addAttribute("username", "Witaj "+UserFileHandler.getUserName());
            clientService.setuserparameters();
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
