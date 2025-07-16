package com.amrut.prabhu.oauth2.client;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/api")
public class Controller {

    @GetMapping("/diennt")
    public String index(Principal principal) {
        return principal.getName();
    }
}