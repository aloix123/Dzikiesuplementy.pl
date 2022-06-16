package project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import project.service.ClientService;


@Controller
public class ClientController {



    @Autowired
    private ClientService clientService;

    @GetMapping("/")
    public String viewHomePage() {
        return "home.html";
    }

    @GetMapping("/error")
    public String viewErrorPage() {
        return "error_page.html";
    }


















}
