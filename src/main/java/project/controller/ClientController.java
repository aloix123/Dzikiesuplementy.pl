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

    @GetMapping("/register")
    public String getRegisterPage(Model model) {
        model.addAttribute("registerRequest", new Client());
        return "register_page";
    }



    @GetMapping("/personal")
    public String personalPage() {
        return "personal_page";
    }

    @GetMapping("/creatine")
    public String creatinePage() {
        return "Creatine";
    }

    @GetMapping("/preworkout")
    public String preworkoutPage() {
        return "Preworkout";
    }

    @GetMapping("/whey")
    public String wheyPage() {
        return "Whey";
    }

    @GetMapping("/newspaper")
    public String newspaperPage() {
        return "Newspaper";
    }

    @GetMapping("/cart")
    public String cartPage() {
        return "koszyk";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute Client client) {
        System.out.println("register request: " + client);
        Client reqisteredClient = clientService.registerClient(client.getName(), client.getSurname(), client.getEmail(),
                client.getPassword());
        return reqisteredClient == null ? "error_page" : "redirect:/login";
    }


}
