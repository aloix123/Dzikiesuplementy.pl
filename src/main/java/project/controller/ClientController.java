package project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import project.service.ClientService;
import project.model.Client;


@Controller
public class ClientController {

    boolean isLoggedIn = false;

    @Autowired
    private ClientService clientService;

    @GetMapping("/")
    public String viewHomePage() {
        return "index.html";
    }

    @GetMapping("/register")
    public String getRegisterPage(Model model){
        model.addAttribute("registerRequest", new Client());
        return "register_page";
    }

    @GetMapping("/login")
    public String getLoginPage(Model model){
        model.addAttribute("loginRequest", new Client());
        return "login_page";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute Client client){
        System.out.println("register request: " + client);
        Client reqisteredClient = clientService.registerClient(client.getName(), client.getSurname(), client.getEmail(),
                client.getPassword());
        return reqisteredClient == null ? "error_page" : "redirect:/login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute Client client, Model model){
        System.out.println("login request: " + client);
        Client authenticated = clientService.authenticate(client.getEmail(),
                client.getPassword());
        if(authenticated != null) {
            model.addAttribute("userEmail", authenticated.getEmail());
            isLoggedIn = true;
            return "personal_page";
        }else {
            return "error_page";
        }
    }
}
