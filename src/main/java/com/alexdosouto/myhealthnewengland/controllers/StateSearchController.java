package com.alexdosouto.myhealthnewengland.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StateSearchController {

    @GetMapping("/state")
    public String stateSearch() {
        return "State";
    }
}
