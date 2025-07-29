package com.amrut.prabhu.oauth2.client;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller class to handle requests.
 * This class is part of the OAuth2 client application.
 * It provides an endpoint to check if the application is running.
 */ 

@RestController
@RequestMapping("/api")
public class Controller {
    @GetMapping
    public String index() {
        return "🌐 Spring Cloud Gateway is running on port 9090!";
    }
}