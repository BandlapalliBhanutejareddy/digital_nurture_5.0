package com.dn5.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {
    
    @GetMapping("/api/status")
    public String getStatus() {
        return "Service is up and running!";
    }
}
