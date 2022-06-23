package com.alexdosouto.myhealthnewengland.entitymodels;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;


@Entity
@Getter
@Setter
@RequiredArgsConstructor
@ToString
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

    @ManyToMany(targetEntity = HealthProvider.class, cascade = CascadeType.ALL)
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


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(uId, user.uId) && Objects.equals(uEmail, user.uEmail) && Objects.equals(uName, user.uName) && Objects.equals(uPassword, user.uPassword) && Objects.equals(uHealthProvider, user.uHealthProvider) && Objects.equals(roles, user.roles);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uId, uEmail, uName, uPassword, uHealthProvider, roles);
    }
}
