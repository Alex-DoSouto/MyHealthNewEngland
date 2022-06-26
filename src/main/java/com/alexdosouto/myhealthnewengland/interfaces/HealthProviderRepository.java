package com.alexdosouto.myhealthnewengland.interfaces;

import com.alexdosouto.myhealthnewengland.entitymodels.HealthProvider;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface HealthProviderRepository extends JpaRepository<HealthProvider, String> {


    @Query("SELECT DISTINCT p.pState FROM HealthProvider p")
    List<String> findDistinctState();


    List<HealthProvider> findBypState(String state);
}
