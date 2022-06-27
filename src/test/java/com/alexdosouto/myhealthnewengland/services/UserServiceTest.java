package com.alexdosouto.myhealthnewengland.services;

import com.alexdosouto.myhealthnewengland.Services.UserService;
import com.alexdosouto.myhealthnewengland.entitymodels.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

// Testing the Method in UserService by setting an email in the Database then checking if it's null or not
@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Transactional
class UserServiceTest {


    @Autowired
    private UserService userService;

    @Test
    public void testFindByUEmail() {

        User user = userService.findByEmail("123@123.com");
        assertThat(user).isNotNull();
    }
}