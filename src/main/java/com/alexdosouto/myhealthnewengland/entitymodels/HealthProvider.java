package com.alexdosouto.myhealthnewengland.entitymodels;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "health_providers")
//Stores HealthProviders in the database
public class HealthProvider {
    @Id
    @Column(nullable = false, unique = false, name = "provider_name")
    private String pName;

    @Column(nullable = false, name = "provider_hyperlink")
    private String pHyperLink;

    @Column(nullable = false, name = "provider_state")
    private String pState;

}
