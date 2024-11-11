package io.moun.api.member.infrastructure;

import io.moun.api.member.domain.Auth;
import io.moun.api.member.domain.Role;
import io.moun.api.member.domain.repository.AuthRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Collection;
import java.util.stream.Collectors;

public class UserDetailsServiceImpl implements UserDetailsService {


    private AuthRepository authRepository;
    @Autowired
    public UserDetailsServiceImpl(AuthRepository authRepository) {
        this.authRepository = authRepository;
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Auth auth = authRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException(username));
        return new User(auth.getUsername(), auth.getPassword(),mapRolesToAuthorities(auth.getRoles()));

    }
    private Collection<GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles) {
        return roles.stream().map(role->new SimpleGrantedAuthority(role.getRole())).collect(Collectors.toList());
    }
}
