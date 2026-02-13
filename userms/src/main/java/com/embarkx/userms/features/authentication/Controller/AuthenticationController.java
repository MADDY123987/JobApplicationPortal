package com.embarkx.userms.features.authentication.Controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/authentication")
public class AuthenticationUser {

    @GetMapping("/user")
    public  String getUser()
    {
        return "User";
    }

}
