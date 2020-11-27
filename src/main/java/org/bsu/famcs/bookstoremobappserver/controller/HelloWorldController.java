package org.bsu.famcs.bookstoremobappserver.controller;

import org.bsu.famcs.bookstoremobappserver.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    TestService testService;

    @Autowired
    private HelloWorldController(TestService testService) {
        this.testService = testService;
    }

    @GetMapping("/authors")
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
