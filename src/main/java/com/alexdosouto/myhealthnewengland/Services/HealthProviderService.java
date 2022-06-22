package com.alexdosouto.myhealthnewengland.Services;


import com.alexdosouto.myhealthnewengland.entitymodels.HealthProvider;
import com.alexdosouto.myhealthnewengland.interfaces.HealthProviderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HealthProviderService {

    @Autowired
    private HealthProviderRepository repo;

    public List<String> findDistinctState() {
        return repo.findDistinctState();
    }

    public List<HealthProvider> findBypState(String state) {
        return repo.findBypState(state);
    }
}
