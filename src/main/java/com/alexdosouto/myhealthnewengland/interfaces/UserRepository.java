package com.alexdosouto.myhealthnewengland.interfaces;

import com.alexdosouto.myhealthnewengland.entitymodels.User;
import org.hibernate.sql.Delete;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    //Find the user by the email entered
    @Query("SELECT u FROM User u WHERE u.uEmail = ?1")
    User findByUEmail(String uEmail);


    @Transactional
    @Query("delete from User where uId=?1")
    void deleteByPlzId(Long uId);
}
