package net.myslipp.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class WelcomeController {

    @GetMapping("/hello")
    public String welcome(String name, int age, Model model){
        System.out.println("name : " + name);
        model.addAttribute("name", name);
        model.addAttribute("age", age);
        return "welcome";
    }

    @GetMapping("/form")
    public String from(){
        return "form";
    }
}
