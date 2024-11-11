package io.moun.api.member.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@Table(name="users")
public class Auth {
    @Id
    @NotNull
    private String username;
    @NotNull
    private String password;
    @NotNull
    private int enabled;

    @OneToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
    @JoinColumn(name ="username")
    private List<Role> roles;
}
