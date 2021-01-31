package net.myslipp.web;


import net.myslipp.domain.User;
import net.myslipp.domain.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserRepository userRepository; //userRepository 자동으로 땡겨서 쓴다.

    @PostMapping("/create")
    public String create(User user){

        System.out.print("email: " + user);
        userRepository.save(user);
        return "redirect:/list";
    }


    @GetMapping("/list")
    public String list(Model model){
        model.addAttribute("users", userRepository.findAll());
        return "list";
    }

}
