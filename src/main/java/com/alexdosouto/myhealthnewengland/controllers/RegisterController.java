package com.alexdosouto.myhealthnewengland.controllers;

import com.alexdosouto.myhealthnewengland.Services.UserService;
import com.alexdosouto.myhealthnewengland.entitymodels.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class RegisterController {

    @Autowired
    private UserService userService;


    @GetMapping("/register")
    public String viewSignUpForm(Model model) {
        // Directs User to the registration page
        model.addAttribute("user", new User());
        return "register";
    }
    @PostMapping("/process_register")
    public String processRegistration(User user, RedirectAttributes redirectAttributes) {
        // registers user to the Database and throws an exception if the user enters the same email
           try {
               userService.registerUser(user);
           } catch (Exception e) {
               redirectAttributes.addFlashAttribute("userExists", "User with this email already exists!");

               return "redirect:/register?failed";
           }
        return"register_success";
    }

}
