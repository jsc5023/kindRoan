package com.example.loan.config;

import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .authorizeRequests((auth) -> auth
                        .requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll()
                        .requestMatchers(HttpMethod.GET, "/security/*", "/","/index", "/js/**").permitAll()
                        .anyRequest().authenticated())
                .formLogin((formLogin) -> formLogin.loginPage("/security/login")
                .loginProcessingUrl("/security/loginProc")
                        .defaultSuccessUrl("/"))
                .logout((logout) -> logout.logoutSuccessUrl("/"))
                .build();

//
//            .formLogin((formLogin) -> formLogin.loginPage("/security/login")
//                .loginProcessingUrl("/security/loginProc")
//                .defaultSuccessUrl("/index"))
//                .logout((logout) ->
//                        logout.logoutSuccessUrl("/index"))

//        return http
//                .csrf(AbstractHttpConfigurer::disable)
//                .authorizeRequests((authz) -> authz
//                        .requestMatchers("/index", "/css/**", "/images/**", "/js/**").permitAll()
//                        .anyRequest().authenticated())
//                .formLogin((formLogin) ->
//                        formLogin.loginPage("security/login.html")
//                                .defaultSuccessUrl(".")
//                ).logout((logout) ->
//                        logout.logoutSuccessUrl("security/login.html")
//                                .invalidateHttpSession(true)
//                ).build();

    }
}
