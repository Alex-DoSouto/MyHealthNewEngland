package com.alexdosouto.myhealthnewengland.interfaces;


import com.alexdosouto.myhealthnewengland.entitymodels.HealthProvider;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class HealthProviderRepositoryTest {

    @Autowired
    private HealthProviderRepository repo;

    @Test
    public void testFindDistinctState() {
        List<String> pState = new ArrayList<>();
        pState.add("Massachusetts");
        pState.add("Rhode Island");
        pState.add("New Hampshire");
        pState.add("Maine");
        pState.add("Connecticut");
        pState.add("Vermont");

        List<String> findDistinctState = repo.findDistinctState();
        assertThat(pState).isEqualTo(findDistinctState);

    }

    @Test
    public void testFindByPState() {
        HealthProvider hp = repo.findById("TUFTS Health").get();
        String pState = "Massachusetts";

        List<HealthProvider> healthProvider = repo.findBypState(pState);

        healthProvider.forEach(System.out::println);

        assertThat(healthProvider).contains(hp);

    }
}
