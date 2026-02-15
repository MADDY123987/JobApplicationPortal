package com.embarkx.userms.features.authentication.Service;

import com.embarkx.userms.features.authentication.dto.AuthenticationRequestBody;
import com.embarkx.userms.features.authentication.dto.AuthenticationResponseBody;
import com.embarkx.userms.features.authentication.model.AuthenticationUser;
import com.embarkx.userms.features.authentication.repository.AuthenticationUserRepository;
import com.embarkx.userms.features.authentication.utils.Encoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    private final Encoder encoder;
    private final AuthenticationUserRepository authenticationUserRepository;

    public AuthenticationService(Encoder encoder, AuthenticationUserRepository authenticationUserRepository) {
        this.encoder = encoder;
        this.authenticationUserRepository = authenticationUserRepository;
    }

    public AuthenticationUser getUser(String email) {
        return authenticationUserRepository
                .findByEmail(email)
                .orElseThrow(() -> new IllegalArgumentException("User not Found"));
    }

    public AuthenticationResponseBody register(AuthenticationRequestBody registerRequestBody) {
        authenticationUserRepository.save(new AuthenticationUser(registerRequestBody.getEmail(),encoder.encode(registerRequestBody.getPassword() ))) ;
        return new AuthenticationResponseBody("token","Users Registered Succesfully");
    }
}
