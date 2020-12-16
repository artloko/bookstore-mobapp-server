package org.bsu.famcs.bookstoremobappserver.service;

import org.bsu.famcs.bookstoremobappserver.repository.UserRepository;
import org.bsu.famcs.bookstoremobappserver.repository.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service("userService")
public class PostgresUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Autowired
    public PostgresUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserEntity userEntity = userRepository.findUserByEmail(email);

        if (userEntity == null)
            throw new UsernameNotFoundException("User '" + email + "' not found");

        GrantedAuthority authority = new SimpleGrantedAuthority(userEntity.getRole().name());
        return new org.springframework.security.core.userdetails.User(userEntity.getEmail(), userEntity.getPasswordEncrypted(), Arrays.asList(authority));
    }
}
