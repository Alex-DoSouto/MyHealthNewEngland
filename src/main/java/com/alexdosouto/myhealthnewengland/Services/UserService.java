package com.alexdosouto.myhealthnewengland.Services;

import com.alexdosouto.myhealthnewengland.entitymodels.User;
import com.alexdosouto.myhealthnewengland.interfaces.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    public void registerUser(User user) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(user.getUPassword());
        user.setUPassword(encodedPassword);
        repo.save(user);
    }
}
