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

    @PostMapping("/security/sign-up")
        public String signUp(HttpServletRequest request, Model model) {
        String userId = request.getParameter("userId");
        String password = request.getParameter("password");
        String confirmPassword = request.getParameter("confirm-password");
        String email = request.getParameter("email");

        if(!password.equals(confirmPassword)) {
            model.addAttribute("error", "비밀번호와 비밀번호 확인의 내용이 같지 않습니다");
        }

        return "/security/login";
    }
}
