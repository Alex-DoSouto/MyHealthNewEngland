package com.alexdosouto.myhealthnewengland.controllers;

import com.alexdosouto.myhealthnewengland.Services.UserService;
import com.alexdosouto.myhealthnewengland.entitymodels.CustomUserDetails;
import com.alexdosouto.myhealthnewengland.entitymodels.User;
import com.alexdosouto.myhealthnewengland.interfaces.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

@Controller
public class LoggedInProfileController {

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private UserService userService;

    @GetMapping("/profile")
    public String profile(Model model) {
        // Directs User to the profile page
        model.addAttribute("user", userService.getPrincipal());
        return "Profile";
    }

    @PostMapping("/profile")
    public String updateProfile(HttpServletRequest request) throws ServletException {
        //Updates the Email, Name, and Password of the logged-in user
        User user = userRepo.findByUEmail(request.getParameter("oldPlzEmail"));
        user.setUEmail(request.getParameter("plzEmail"));
        user.setUName(request.getParameter("plzName"));
        user.setUPassword(request.getParameter("plzPassword"));
        userService.updateUser(user);
        request.logout();
        return "redirect:/login";
    }
    @DeleteMapping("/delete")
    public String deleteUser(HttpServletRequest request) throws ServletException {
        //Deletes the user profile still logged in
        userRepo.deleteById(Long.valueOf(request.getParameter("plzId")));
        request.logout();
        return "redirect:/register";
    }
}
