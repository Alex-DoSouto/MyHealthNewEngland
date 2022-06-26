package com.alexdosouto.myhealthnewengland.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
    @GetMapping("/login")
    //Directs user to the login page
    public String login() {
        return "login";

    }
}
