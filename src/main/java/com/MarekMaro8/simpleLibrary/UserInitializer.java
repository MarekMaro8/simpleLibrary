package com.MarekMaro8.simpleLibrary;

import com.MarekMaro8.simpleLibrary.model.User;
import com.MarekMaro8.simpleLibrary.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class UserInitializer {

    @Bean
    CommandLineRunner init(UserRepository userRepo, PasswordEncoder encoder) {
        return args -> {
            if (userRepo.findByUsername("marospros").isEmpty()) {
                User user = new User();
                user.setUsername("marospros");
                user.setPassword(encoder.encode("marek123")); // Szyfrowane hasło!
                user.setRole("ROLE_USER");
                userRepo.save(user);
                System.out.println("✅ Dodano testowego użytkownika: marospros / marek123");
            }
        };
    }
}
