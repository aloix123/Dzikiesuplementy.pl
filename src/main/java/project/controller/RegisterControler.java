package project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import project.model.Client;
import project.service.ClientService;

import javax.validation.Valid;

@Controller
public class RegisterControler {
    @Autowired
    private ClientService clientService;
    @GetMapping("/registration")
    public String getRegisterPage(Model model) {

        Client client=new Client();
        model.addAttribute("client",client);
        return "register_page.html";
    }
    @PostMapping("/registration")
    public String createNewUser(@ModelAttribute("client") Client student) {
        clientService.saveClient(student);
        UserDetails user= User.withDefaultPasswordEncoder()
                .username(student.getName())
                .password(student.getPassword())
                .roles("USER")
                .build();
        InMemoryUserDetailsManager cos=new InMemoryUserDetailsManager(user);
        return "redirect:/";
    }

//TODO
//sprawdź czy urzytkownik jest w bazie i potem go dodaj
//poczytaj potem o przekierowaniu na stronę główną wraz z zalogowanym urzytkownikiem
}
