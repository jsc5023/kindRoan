package com.example.loan.config.auth;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URLEncoder;

@Component
public class CustomAuthFailureHandler extends SimpleUrlAuthenticationFailureHandler {


    /* 로그인 인증실패 분기 */
    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        int errorCode;

        if(exception instanceof BadCredentialsException) {
            errorCode = 1;

        } else {
            errorCode = 99;
        }

        setDefaultFailureUrl("/security/login?error=true&exception="+ errorCode);

        super.onAuthenticationFailure(request, response, exception);
    }

}
