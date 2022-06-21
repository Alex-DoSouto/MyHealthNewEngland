package com.alexdosouto.myhealthnewengland.interfaces;

import com.alexdosouto.myhealthnewengland.entitymodels.HealthProvider;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HealthProviderRepository extends JpaRepository<HealthProvider, String> {

}
