package com.alexdosouto.myhealthnewengland.Services;

import com.alexdosouto.myhealthnewengland.entitymodels.CustomUserDetails;
import com.alexdosouto.myhealthnewengland.entitymodels.User;
import com.alexdosouto.myhealthnewengland.interfaces.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository repo;

    @Override
    public UserDetails loadUserByUsername(String uEmail) throws UsernameNotFoundException {
        User user = repo.findByUEmail(uEmail);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return new CustomUserDetails(user);
    }
}
