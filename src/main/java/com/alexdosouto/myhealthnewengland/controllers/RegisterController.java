package com.alexdosouto.myhealthnewengland.controllers;

import com.alexdosouto.myhealthnewengland.Services.UserService;
import com.alexdosouto.myhealthnewengland.entitymodels.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegisterController {

    @Autowired
    private UserService userService;


    @GetMapping("/register")
    public String viewSignUpForm(Model model) {
        // Directs User to the registration page
        model.addAttribute("user", new User());
        return "form";
    }
    @PostMapping("/process_register")
    public String processRegistration(User user) {
        // registers user to the Database and throws an exception if the user enters the same email
            userService.registerUser(user);
        return"register_success";
    }

}
