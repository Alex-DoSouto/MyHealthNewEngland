package com.alexdosouto.myhealthnewengland.controllers;

import com.alexdosouto.myhealthnewengland.Services.HealthProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StateSearchController {

    @Autowired
    private HealthProviderService healthProviderService;


    @GetMapping("/state")
    public String stateSearch(Model model) {
        model.addAttribute("statedropdown", healthProviderService.findDistinctState());
        return "State";
    }
}
