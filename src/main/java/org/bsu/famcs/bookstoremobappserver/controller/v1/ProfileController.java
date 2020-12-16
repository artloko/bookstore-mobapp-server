package org.bsu.famcs.bookstoremobappserver.controller.v1;

import org.bsu.famcs.bookstoremobappserver.controller.entity.UserInfoRs;
import org.bsu.famcs.bookstoremobappserver.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProfileController {


    private final LoginService loginService;

    @Autowired
    public ProfileController(LoginService loginService) {
        this.loginService = loginService;
    }

    @GetMapping("/user/info")
    @ResponseBody
    public UserInfoRs signUp(@RequestParam String email) {
        return loginService.getUserInfo(email);
    }
}
