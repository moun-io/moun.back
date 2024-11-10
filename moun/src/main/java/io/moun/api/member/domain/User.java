package io.moun.api.member.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.List;

@Entity
@Table(name="users")
public class User {
    @Id
    @NotNull
    private String username;
    @NotNull
    private String password;
    @NotNull
    private int enabled;

    @OneToMany
    @JoinColumn(name="username")
    private List<Authority> authorities;
}
