package com.example.loan.controller;

import com.example.loan.config.auth.AuthErrorCode;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

    @GetMapping("/security/login")
    public String login(@RequestParam(value = "error", required = false) String error,
                        Model model) {

        if(error != null && !error.trim().isEmpty()) {
            int errorCode = Integer.parseInt(error);
            String exception = AuthErrorCode.getExplanationByCode(errorCode);

            model.addAttribute("error", error);
            model.addAttribute("exception", exception);
        }

        return "/security/login";
    }


    @GetMapping("/security/sign-up")
    public String signUp() {
        return "/security/sign-up";
    }
}
