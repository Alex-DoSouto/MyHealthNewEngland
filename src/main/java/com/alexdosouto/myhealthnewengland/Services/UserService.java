package com.alexdosouto.myhealthnewengland.Services;


import com.alexdosouto.myhealthnewengland.entitymodels.Role;
import com.alexdosouto.myhealthnewengland.entitymodels.User;
import com.alexdosouto.myhealthnewengland.interfaces.RoleRepository;
import com.alexdosouto.myhealthnewengland.interfaces.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;


@Service
public class UserService {

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private RoleRepository roleRepo;

    public void registerUser(User user) {
        //takes the entered user password and sets is to a hashed value
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(user.getUPassword());
        user.setUPassword(encodedPassword);

        //finds the user by their name in the user table and adds the "User" role to the registered user
        Role roleUser = roleRepo.findByName("User");
        user.addRole(roleUser);
        userRepo.save(user);
    }
    public void updateUser(User user) {
        //takes the entered user password and sets is to a hashed value
       BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
       String encodedPassword = passwordEncoder.encode(user.getUPassword());
       user.setUPassword(encodedPassword);
       userRepo.save(user);
    }
    //finds the user by their email as the Authentication of the user and returns there name
    public User getPrincipal() {
        return userRepo.findByUEmail(SecurityContextHolder.getContext().getAuthentication().getName());
    }
    public User findByEmail(String uEmail) {

        return userRepo.findByUEmail(uEmail);
    }
    public void deleteTheUser(HttpServletRequest request) throws ServletException {
        userRepo.deleteById(Long.valueOf(request.getParameter("plzId")));
        request.logout();
    }


}
