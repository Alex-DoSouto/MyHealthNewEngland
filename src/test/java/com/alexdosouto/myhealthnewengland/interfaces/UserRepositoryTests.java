package com.alexdosouto.myhealthnewengland.interfaces;

import static org.assertj.core.api.Assertions.assertThat;

import com.alexdosouto.myhealthnewengland.entitymodels.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class UserRepositoryTests {
    @Autowired
    private UserRepository repo;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void testCreateUser() {
        User user = new User();
        user.setUEmail("mud@dud.com");
        user.setUPassword("password");
        user.setUName("mud");

        User savedUser = repo.save(user);

        User existUser = entityManager.find(User.class, savedUser.getUId());

        assertThat(existUser.getUEmail()).isEqualTo(existUser.getUEmail());
    }

    @Test
    public void testFindUserByUEmail() {
        String uEmail = "Test@email.com";

        User user = repo.findByUEmail(uEmail);
        assertThat(user).isNotNull();
    }

}
