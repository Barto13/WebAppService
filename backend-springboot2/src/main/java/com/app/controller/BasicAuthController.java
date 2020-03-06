package com.app.controller;

import com.app.config.Auth;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("/")
public class BasicAuthController {

    @GetMapping(path = "/basicauth")
    public Auth basicauth() {
        return new Auth("You are authenticated");
    }
}
