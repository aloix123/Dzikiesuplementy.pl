package project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import project.service.ClientService;
import project.model.Client;


@Controller
public class ClientController {



    @Autowired
    private ClientService clientService;

    @GetMapping("/")
    public String viewHomePage() {
        return "index.html";
    }

    @GetMapping("/error")
    public String viewErrorPage() {
        return "error_page.html";
    }


















}
