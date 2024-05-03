package com.example.platformormanagingahotel.business.api.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {


    @GetMapping("/login")
    public String handleLogin() {
        return "custom_login";
    }


}

