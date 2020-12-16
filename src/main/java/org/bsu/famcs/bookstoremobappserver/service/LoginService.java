package org.bsu.famcs.bookstoremobappserver.service;

import org.bsu.famcs.bookstoremobappserver.controller.entity.SignUpUserRq;
import org.bsu.famcs.bookstoremobappserver.controller.entity.UserInfoRs;
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

    public UserEntity save(SignUpUserRq u) {
        UserEntity userEntity = u.convert();
        userEntity.setPasswordEncrypted(passwordEncoder.encode(u.getPasswordEncrypted()));
        return userRepository.save(userEntity);
    }

    public UserInfoRs getUserInfo(String email) {
        return new UserInfoRs(userRepository.findUserByEmail(email));
    }
}
