package com.cassiano.pos.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.cassiano.pos.entities.User;
import com.cassiano.pos.repositories.UserRepository;

@Service
public class CustomUserDetailsService
        implements UserDetailsService {

    private final UserRepository repository;

    public CustomUserDetailsService(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String barcode)
            throws UsernameNotFoundException {

        User user = repository.findByBarcode(barcode)
                .orElseThrow(() -> new UsernameNotFoundException(
                        "Usuário não encontrado"));

        return new UserDetailsImpl(user);
    }

}
