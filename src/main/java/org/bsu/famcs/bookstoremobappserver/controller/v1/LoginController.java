package org.bsu.famcs.bookstoremobappserver.controller.v1;

import org.bsu.famcs.bookstoremobappserver.repository.entity.UserEntity;
import org.bsu.famcs.bookstoremobappserver.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    private final PasswordEncoder passwordEncoder;

    private final LoginService loginService;

    @Autowired
    public LoginController(PasswordEncoder passwordEncoder, LoginService loginService) {
        this.passwordEncoder = passwordEncoder;
        this.loginService = loginService;
    }

    @PostMapping("/sign-up")
    public void signUp(@RequestBody UserEntity userEntity) {
        loginService.save(userEntity);
    }
}
