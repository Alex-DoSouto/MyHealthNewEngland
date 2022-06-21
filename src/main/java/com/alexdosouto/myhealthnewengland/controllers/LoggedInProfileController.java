package com.alexdosouto.myhealthnewengland.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoggedInProfileController {

    @GetMapping("/profile")
    public String profile() {
        return "Profile";
    }
}
