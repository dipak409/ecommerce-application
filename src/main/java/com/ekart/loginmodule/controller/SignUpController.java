package com.ekart.loginmodule.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SignUpController {
//username, password encrypt
    @PostMapping("/signup")
    public String create()
    {
        return "Hello world";
    }
}
