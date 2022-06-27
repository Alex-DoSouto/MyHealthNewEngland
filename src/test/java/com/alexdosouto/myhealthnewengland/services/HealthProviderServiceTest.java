package com.alexdosouto.myhealthnewengland.services;

import com.alexdosouto.myhealthnewengland.Services.HealthProviderService;
import com.alexdosouto.myhealthnewengland.entitymodels.HealthProvider;
import com.alexdosouto.myhealthnewengland.interfaces.HealthProviderRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

// Testing the Method in HealthProviderService by setting a healthcare provider and finding their state
@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
class HealthProviderServiceTest {

    @Autowired
    private HealthProviderService service;

    @Autowired
    private HealthProviderRepository repo;

    @Test
    public void testFindByState() {
        HealthProvider hp = repo.findById("Cigna").get();
        String pState = "Rhode Island";

        List<HealthProvider> healthProvider = service.findBypState(pState);

        healthProvider.forEach(System.out::println);

        assertThat(healthProvider).contains(hp);
    }

}