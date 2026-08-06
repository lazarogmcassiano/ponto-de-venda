package com.cassiano.pos.security;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.cassiano.pos.entities.Permission;
import com.cassiano.pos.entities.User;

public class UserDetailsImpl implements UserDetails {

    private final User user;

    public UserDetailsImpl(User user) {
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        Set<GrantedAuthority> authorities = new HashSet<>();

        authorities.add(
                new SimpleGrantedAuthority(
                        "ROLE_" + user.getRole().getName()));

        for (Permission permission : user.getRole().getPermissions()) {

            authorities.add(
                    new SimpleGrantedAuthority(
                            permission.getName()));
        }

        for (Permission permission : user.getExtraPermissions()) {

            authorities.add(
                    new SimpleGrantedAuthority(
                            permission.getName()));
        }

        return authorities;
    }

    public String getRole() {
        return user.getRole().getName();
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getBarcode();
    }

    @Override
    public boolean isEnabled() {
        return user.getActive();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

}
