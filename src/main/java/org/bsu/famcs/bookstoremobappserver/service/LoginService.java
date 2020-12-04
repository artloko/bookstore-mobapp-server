package org.bsu.famcs.bookstoremobappserver.service;

import org.bsu.famcs.bookstoremobappserver.repository.UserRepository;
import org.bsu.famcs.bookstoremobappserver.repository.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.security.auth.login.LoginException;

@Service
public class LoginService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public LoginService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public Iterable<UserEntity> getUsers() {
        return userRepository.findAll();
    }

    public UserEntity save(UserEntity u) {
        return userRepository.save(u);
    }

    public UserEntity login(String email, String password) throws LoginException {
        UserEntity userEntity = userRepository.findUserByEmail(email);
        if (passwordEncoder.matches(password, userEntity.getPasswordEncrypted()))
            return userEntity;
        else throw new LoginException("There is no such user");
    }
}
