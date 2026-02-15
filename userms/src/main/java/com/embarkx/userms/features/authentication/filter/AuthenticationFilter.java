package com.embarkx.userms.features.authentication.filter;


import jakarta.servlet.http.HttpFilter;
import org.springframework.stereotype.Component;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class AuthenticationFilter extends HttpFilter {
    private final List<String>unsecuredEndpoints= Arrays.asList(
            "/api/v1/authentication/user",
            "/api/v1/authentication/login",
            "/api/v1/authentication/register",
            "/api/v1/authentication"
    );
}
