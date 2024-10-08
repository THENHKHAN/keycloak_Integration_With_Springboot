package com.example.keycloakIntegrationInSb.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/kc/v1")
public class HomeControlller {

    @GetMapping("/")
    public ResponseEntity<String> myHomeBasePage(){
        return ResponseEntity.ok("This is my home Base page /");
    }

    @GetMapping("/home")
    public ResponseEntity<String> myHomePage(){
        return ResponseEntity.ok("This is my home page /home");
    }


    @GetMapping("/home2")
    public ResponseEntity<String> myHomePage2(){
        return ResponseEntity.ok("Hello From Spring boot & keycloak /home2");
    }


    @GetMapping("/home3")
    public ResponseEntity<String> myHomePage3(){
        return ResponseEntity.ok("Hello From Spring boot & keycloak - ADMIN   /home3");
    }
}
