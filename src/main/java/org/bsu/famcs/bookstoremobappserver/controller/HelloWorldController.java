package org.bsu.famcs.bookstoremobappserver.controller;

import org.bsu.famcs.bookstoremobappserver.repository.entity.User;
import org.bsu.famcs.bookstoremobappserver.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    private final TestService testService;

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public HelloWorldController(TestService testService, PasswordEncoder passwordEncoder) {
        this.testService = testService;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping
    User signIn(@RequestParam String email, @RequestParam String password) {
        User u = new User();
        u.setEmail(email);
        u.setPasswordEncrypted(passwordEncoder.encode(password));
        return testService.save(u);
    }

    @GetMapping("/authors")
    @PreAuthorize("hasAuthority('USER')")
    public String getAuthors() {
        return testService.getAuthors().toString();
    }

    @GetMapping("/books")
    public String getBooks() {
        return testService.getBooks().toString();
    }

    @GetMapping("/favorites")
    public String getFavorites() {
        return testService.getFavorites().toString();
    }

    @GetMapping("/genres")
    public String getGenres() {
        return testService.getGenres().toString();
    }

    @GetMapping("/orders")
    public String getOrders() {
        return testService.getOrders().toString();
    }

    @GetMapping("/users")
    public String getUsers() {
        return testService.getUsers().toString();
    }

    @PostMapping("/")
    public String postHome() {
        return "POST. Hello Docker World. Deployed on commit :)";
    }
}
