package io.moun.api.security.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "users")
public class Auth {
    @Id
    @NotNull
    private String username;
    @NotNull
    private String password;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "username")
    private List<Role> roles = new ArrayList<Role>();

    public void addRole(String roleType) {
        roles.add(new Role(username, roleType));
    }
}
