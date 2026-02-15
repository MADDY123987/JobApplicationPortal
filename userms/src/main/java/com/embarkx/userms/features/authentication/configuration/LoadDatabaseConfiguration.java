package com.embarkx.userms.features.authentication.configuration;


import com.embarkx.userms.features.authentication.model.AuthenticationUser;
import com.embarkx.userms.features.authentication.repository.AuthenticationUserRepository;
import com.embarkx.userms.features.authentication.utils.Encoder;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadDatabaseConfiguration {
    public LoadDatabaseConfiguration(Encoder encoder) {
        this.encoder = encoder;
    }

    private final Encoder encoder;
    @Bean
    public CommandLineRunner initDatabase(AuthenticationUserRepository authenticationUserRepository) {
        return args -> {
            AuthenticationUser authenticationUser =
                    new AuthenticationUser(
                            "madhavan20041@gmail",
                            encoder.encode("Deeksha")
                    );

            authenticationUserRepository.save(authenticationUser);
        };
    }
}
