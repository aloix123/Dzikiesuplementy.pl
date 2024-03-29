package project.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import project.model.Client;
import project.model.User;
import project.service.ClientService;
import project.service.UserService;

import java.io.IOException;

@Controller
public class RegisterControler {
    @Autowired
    private UserService userService;
    @Autowired
    private ClientService clientService;
    @GetMapping("/registration")
    public String getRegisterPage(Model model) {
        User user=new User();
        Client client=new Client();
        model.addAttribute("client",client);
        model.addAttribute("user",user);
        return "register_page.html";
    }
    @PostMapping("/registration")
    public String createNewUser(@ModelAttribute("client") Client newclient,@ModelAttribute("user") User user,Model model) throws IOException {
        User user1=new User(user.getUsername(),user.getPassword());
        userService.saveuser(user1);
        Client client=new Client(user1.getId(),newclient.getAdress(),newclient.getNumber(),newclient.getName(),newclient.getSurname());
        if (clientService.isClientFieldNull(client,user1) ){
            model.addAttribute("error","nie uzupełniłeś niektórych danych:(");
            return "error_page";
        }
        if(userService.isTHeSameParametersInData(user1)){
            model.addAttribute("error","dana nazwa urzytkownika jest już zajęta:(");
            return "error_page";
        }


        clientService.saveClient(client);

        return "redirect:/";
    }


}
