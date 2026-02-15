package com.embarkx.userms.features.authentication.Controller;


import com.embarkx.userms.features.authentication.Service.AuthenticationService;
import com.embarkx.userms.features.authentication.dto.AuthenticationRequestBody;
import com.embarkx.userms.features.authentication.dto.AuthenticationResponseBody;
import com.embarkx.userms.features.authentication.model.AuthenticationUser;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/authentication")
public class AuthenticationController {
    private final AuthenticationService authenticationService;

    public AuthenticationController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @GetMapping("/user")
    public AuthenticationUser getUser()
    {

        return authenticationService.getUser("madhavan20041@gmail.com");
    }

    @PostMapping("/login")
    public AuthenticationResponseBody loginPage(@Valid @RequestBody AuthenticationRequestBody loginRequestBody)
    {
        return authenticationService.login(loginRequestBody);
    }

    @PostMapping("/register")
    public AuthenticationResponseBody registerPage(@Valid  @RequestBody AuthenticationRequestBody registerRequestBody)
    {
        return authenticationService.register(registerRequestBody);
    }
}
