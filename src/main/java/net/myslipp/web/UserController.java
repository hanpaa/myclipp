package net.myslipp.web;


import net.myslipp.domain.User;
import net.myslipp.domain.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/users") //기본 URL
public class UserController {

    @Autowired
    private UserRepository userRepository; //userRepository 자동으로 땡겨서 쓴다.



    @PostMapping("") //같은 users라도 post 일 경우 +
    public String create(User user){ //commit

        System.out.print("email: " + user);
        userRepository.save(user);
        return "redirect:/users";
    }


    @GetMapping("")
    public String list(Model model){
        model.addAttribute("users", userRepository.findAll());
        return "/user/list";
    }

    @GetMapping("/form")
    public String form(){
        return "/user/form";
    }

    @GetMapping("{id}/form")
    public String updateForm(@PathVariable Long id, Model model){
        User user = userRepository.findById(id).get();
        model.addAttribute("user", user);
        return "/user/updateForm";
    }

    //html은 get와 post만 지원하지만, put쓰는게 좋긴함

    @PutMapping("/{id}")
    public String update(@PathVariable Long id, User updateUser){
        User user = userRepository.findById(id).get();
        user.update(updateUser);
        userRepository.save(user);
        return "redirect:/users";
    }

    @GetMapping("/loginForm")
    public String loginForm(){
        return "/user/login";
    }

    @PostMapping("/login")
    public String login(String userId, String password, HttpSession session){

        User user = userRepository.findByUserId(userId);
        if(user == null){
            return "redirect:/users/loginForm";
        }
        if(!password.equals(user.getPassword())){
            return "redirect:/users/loginForm";

        System.out.println("login Success!");
        //session 사용
        session.setAttribute("user", user);

        return "redirect:/";
    }

    @GetMapping("/profile")
    public String profile(){
        return "/user/profile";
    }


}
