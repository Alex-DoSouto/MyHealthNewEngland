package com.alexdosouto.myhealthnewengland.controllers;

import com.alexdosouto.myhealthnewengland.Services.UserService;
import com.alexdosouto.myhealthnewengland.entitymodels.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AppController {

    @Autowired
    private UserService userService;

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
        userService.registerUser(user);
        return"register_success";
    }

}
