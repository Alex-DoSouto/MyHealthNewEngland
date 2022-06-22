package com.alexdosouto.myhealthnewengland.entitymodels;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, name = "id")
    private Long uId;

    @Column(nullable = false, unique = true, name = "email")
    private String uEmail;

    @Column(nullable = false, name = "name")
    private String uName;

    @Column(nullable = false, length = 64, name = "password")
    private String uPassword;

    @ManyToMany(targetEntity = HealthProvider.class, fetch = FetchType.EAGER)
    @JoinTable(name = "user_choice")
    private List<HealthProvider> uHealthProvider;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
            )
    private Set<Role> roles = new HashSet<>();

    public void addRole(Role role) {
        this.roles.add(role);
    }

}
