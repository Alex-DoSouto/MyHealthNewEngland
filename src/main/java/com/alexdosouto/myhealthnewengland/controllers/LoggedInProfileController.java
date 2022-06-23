package com.alexdosouto.myhealthnewengland.controllers;

import com.alexdosouto.myhealthnewengland.entitymodels.CustomUserDetails;
import com.alexdosouto.myhealthnewengland.entitymodels.User;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class LoggedInProfileController {


    @GetMapping("/profile")
    public String profile(@AuthenticationPrincipal CustomUserDetails user, Model model) {
        model.addAttribute("user", user);
        return "Profile";
    }


}
