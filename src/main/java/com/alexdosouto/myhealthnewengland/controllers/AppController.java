package com.alexdosouto.myhealthnewengland.controllers;

import com.alexdosouto.myhealthnewengland.entitymodels.User;
import com.alexdosouto.myhealthnewengland.interfaces.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AppController {
    @Autowired
    private UserRepository repo;

    @GetMapping("")
    public String viewHomePage() {

        return "index";
    }

    @GetMapping("/register")
    public String viewSignUpForm(Model model) {
        model.addAttribute("user", new User());
        return "form";
    }
    @PostMapping("/process_register")
    public String processRegistration(User user) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(user.getUPassword());
        user.setUPassword(encodedPassword);
        repo.save(user);

        return"register_success";
    }
    @GetMapping("/login")
    public String login() {
        return "login";

    }
}
