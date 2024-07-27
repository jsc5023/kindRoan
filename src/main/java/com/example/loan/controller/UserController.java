package com.example.loan.controller;

import com.example.loan.config.auth.AuthErrorCode;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

    @GetMapping("/security/login")
    public String login() {

        return "/security/login";
    }

    @PostMapping("/security/login")
    public String loginError(HttpServletRequest request, Model model) {
        int errorCode = (Integer) request.getAttribute("errorCode");
        String exception = AuthErrorCode.getExplanationByCode(errorCode);

        model.addAttribute("error", errorCode);
        model.addAttribute("errorMessage", exception);

        return "/security/login";
    }


    @GetMapping("/security/sign-up")
    public String signUp() {
        return "/security/sign-up";
    }
}
