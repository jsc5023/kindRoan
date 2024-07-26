package com.example.loan.config.auth;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class CustomAuthFailureHandler extends SimpleUrlAuthenticationFailureHandler {

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        int errorCode;

        if(exception instanceof BadCredentialsException) {
            errorCode = AuthErrorCode.INVALID_CREDENTIALS.getCode();
        } else {
            errorCode = AuthErrorCode.UNKNOWN_ERROR.getCode();
        }

        setDefaultFailureUrl("/security/login?error="+ errorCode);

        super.onAuthenticationFailure(request, response, exception);
    }

}
