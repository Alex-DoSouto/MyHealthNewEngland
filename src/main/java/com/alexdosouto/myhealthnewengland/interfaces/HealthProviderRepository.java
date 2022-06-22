package com.alexdosouto.myhealthnewengland.interfaces;

import com.alexdosouto.myhealthnewengland.entitymodels.HealthProvider;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface HealthProviderRepository extends JpaRepository<HealthProvider, String> {

    @Query("SELECT DISTINCT p.pState FROM HealthProvider p")
    List<String> findDistinctState();

    // @Query("SELECT * FROM HealthProvider p WHERE p.pState LIKE %?1%")
    List<HealthProvider> findBypState(String state);
}
