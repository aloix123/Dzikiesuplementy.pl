package project.controller;

import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import project.model.Client;
import project.model.User;
import project.service.CartService;
import project.service.ClientService;
import project.service.UserService;
import project.util.ClientFIlehandler;
import project.util.Loginhandler;
import project.util.Personalfilehandler;

import javax.validation.Valid;
import java.io.FileNotFoundException;
import java.util.List;
@Controller
public class PersonalControler {
    @Autowired
    CartService cartService;
    @Autowired ClientService clientService;
    @Autowired
    UserService userService;
    @GetMapping("/personal")
    public String personalPage(Model model) throws FileNotFoundException {
        List<String>  parameters= Personalfilehandler.getparameters();
        model.addAttribute("adress", parameters.get(0));
        model.addAttribute("number", parameters.get(1));
        model.addAttribute("surname", parameters.get(2));
        model.addAttribute("name", parameters.get(3));
        model.addAttribute("id",clientService.getclientid());
        model.addAttribute("flag", "userloggedin");
        return "personal_page";
    }
    @RequestMapping(value = "/personal/edit/{id}",method = RequestMethod.GET)
    public String editPersonalParameters(@PathVariable("id") long id,Model model){
        Client client=clientService.getById(id);
        model.addAttribute("client",client);
        return "updatedata";
    }
    @SneakyThrows
    @RequestMapping(value = "/personal/update/{id}/{uid}",method = RequestMethod.POST)
    public String setPersonalPage( @PathVariable("uid") long uid,@PathVariable("id") long id,Model model,Client client){
        User user = userService.getById(uid);


        clientService.deleteClient(id);
        clientService.saveClient(client);
        ClientFIlehandler clientFIlehandler = new ClientFIlehandler();
        clientFIlehandler.clearfile();
        clientService.setuserparameters();
        cartService.updateClientCarts(id);

        return "redirect:/personal";
    }
    }