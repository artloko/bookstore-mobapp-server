package org.bsu.famcs.bookstoremobappserver.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @GetMapping("/")
    public String getHome() {
        return "GET. Hello Docker World. Deployed on commit :)";
    }

    @PostMapping("/")
    public String postHome() {
        return "POST. Hello Docker World. Deployed on commit :)";
    }
}
