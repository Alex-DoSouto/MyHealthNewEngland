package com.alexdosouto.myhealthnewengland.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomePageController {
    @GetMapping("")
    public String viewHomePage() {
        return "index";
    }
}
