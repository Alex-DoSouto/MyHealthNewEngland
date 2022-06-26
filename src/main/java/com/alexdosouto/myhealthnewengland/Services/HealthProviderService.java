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

    //finds the state in the health provider table and only returns one of each state
    public List<String> findDistinctState() {
        return repo.findDistinctState();
    }

    //turns health provider into a list and searches the state by the string entered
    public List<HealthProvider> findBypState(String state) {
        return repo.findBypState(state);
    }
}
