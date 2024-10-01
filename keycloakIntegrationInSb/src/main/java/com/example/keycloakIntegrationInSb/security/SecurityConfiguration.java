package com.example.keycloakIntegrationInSb.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    @Bean
    public SecurityFilterChain securityFilterChain (HttpSecurity http) throws Exception{
        http
                .csrf( (csrf)-> csrf.disable() )

        .authorizeHttpRequests(auth-> {
                                         auth.requestMatchers("/api/kc/v1/")// Allow access to /api/kc/v1/ without authentication
                                        .permitAll()
                                        .requestMatchers("/v3/api-docs/**", "/swagger-ui/**", "/swagger-resources/**", "/swagger-ui.html", "/webjars/**")
                                        .permitAll()
                                        .anyRequest().authenticated();  // Require authentication for all other requests
                                 });


       http.oauth2ResourceServer()
               .jwt();

        http.sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        return http.build();

    }


}
