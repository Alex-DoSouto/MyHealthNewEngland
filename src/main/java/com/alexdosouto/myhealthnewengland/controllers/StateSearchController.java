package com.alexdosouto.myhealthnewengland.controllers;

import com.alexdosouto.myhealthnewengland.Services.HealthProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class StateSearchController {

    @Autowired
    private HealthProviderService healthProviderService;


    @GetMapping("/state")
    public String stateSearch(Model model) {
        //Directs user to the state page and gives a name and value for Thymeleaf to use statedropdown
        model.addAttribute("statedropdown", healthProviderService.findDistinctState());
        return "State";
    }

    @GetMapping("/state/{results}")
    public String stateResults(@PathVariable String results, Model model) {
        /*Directs user to the state search results page and gives a name and value for Thymeleaf to use statedropdown
        and stateresults
         */
        model.addAttribute("statedropdown", healthProviderService.findDistinctState());
        model.addAttribute("stateresults", healthProviderService.findBypState(results));
        return "state_search_results";
    }
}
