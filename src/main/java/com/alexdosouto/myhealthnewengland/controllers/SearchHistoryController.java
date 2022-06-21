package com.alexdosouto.myhealthnewengland.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SearchHistoryController {

    @GetMapping("/history")
    public String searchHistory() {
        return "search_history";
    }
}
