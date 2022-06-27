package com.alexdosouto.myhealthnewengland.interfaces;

import static org.assertj.core.api.Assertions.assertThat;

import com.alexdosouto.myhealthnewengland.entitymodels.Role;
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
    private UserRepository userRepo;

    @Autowired
    private RoleRepository roleRepo;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void testCreateUser() {
        User user = new User();
        user.setUEmail("mud@dud.com");
        user.setUPassword("password");
        user.setUName("mud");

        User savedUser = userRepo.save(user);

        User existUser = entityManager.find(User.class, savedUser.getUId());

        assertThat(existUser.getUEmail()).isEqualTo(existUser.getUEmail());
    }

    @Test
    public void testFindUserByUEmail() {
        String uEmail = "plz@plz.com";

        User user = userRepo.findByUEmail(uEmail);
        assertThat(user).isNotNull();
    }

    @Test
    public void testAddRoleToNewUser() {
        User user = new User();
        user.setUEmail("max@dud.com");
        user.setUPassword("password");
        user.setUName("mud");

        Role roleUser = roleRepo.findByName("User");
        user.addRole(roleUser);

        User savedUser = userRepo.save(user);

        assertThat(savedUser.getRoles().size()).isEqualTo(1);
    }
    @Test
    public void testAddRolesToExistingUser() {
        User user = userRepo.findById(1L).get();
        Role roleUser = roleRepo.findByName("User");
        user.addRole(roleUser);

        Role roleAdmin = new Role(2L);
        user.addRole(roleAdmin);

        User savedUser = userRepo.save(user);

        assertThat(savedUser.getRoles().size()).isEqualTo(2);
    }
}
