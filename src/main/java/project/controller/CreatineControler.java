package project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import project.service.CreatineService;
import project.util.MainPageHandler;

import javax.persistence.Access;

@Controller
public class CreatineControler {
    @Autowired
    CreatineService creatineService;
    @GetMapping("/creatine")
    public String creatinePage(Model model ){

        if (MainPageHandler.checkIfFileClear()) {
            model.addAttribute("flag", "userloggedin");
        }

        else{
            model.addAttribute("flag","userNotloggedin");
        }
        System.out.println(creatineService.getCreatines());
        model.addAttribute("creatines",creatineService.getCreatines());
        return "Creatine";
    }
}
