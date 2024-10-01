package com.example.keycloakIntegrationInSb.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    @Bean
    public SecurityFilterChain securityFilterChain (HttpSecurity http) throws Exception{
        http
                .csrf( (csrf)-> csrf.disable() )

        .authorizeHttpRequests(auth->{
                                         auth.requestMatchers("/home3")// Allow access to /home3 without authentication
                                        .permitAll()
                                        .anyRequest().authenticated();  // Require authentication for all other requests
                                 });
        return http.build();

    }


}
