package com.alexdosouto.myhealthnewengland.interfaces;

import com.alexdosouto.myhealthnewengland.entitymodels.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Long> {
    @Query("SELECT u FROM User u WHERE u.uEmail = ?1")
    User findByUEmail(String uEmail);

}
