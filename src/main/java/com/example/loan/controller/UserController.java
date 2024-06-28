package com.example.loan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    @GetMapping("/security/login")
    public String login() {
        return "/security/login";
    }

    @GetMapping("/security/sign-up")
    public String signUp() {
        return "/security/sign-up";
    }
}
