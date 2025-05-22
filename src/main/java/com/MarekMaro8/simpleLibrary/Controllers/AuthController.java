package com.MarekMaro8.simpleLibrary.Controllers;

import com.MarekMaro8.simpleLibrary.model.User;
import com.MarekMaro8.simpleLibrary.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    public AuthController(AuthenticationManager authenticationManager, JwtService jwtService, UserRepository userRepository) {
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
        this.userRepository = userRepository;
    }
    private final UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {
        Authentication auth = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword())
        );

        String jwt = jwtService.generateToken(auth.getName());
        return ResponseEntity.ok(new LoginResponse(jwt));
    }


    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody User user) {
        // Sprawdź czy już istnieje taki username
        if (userRepository.findByUsername(user.getUsername()).isPresent()) {
            return ResponseEntity.badRequest().body("Użytkownik o takiej nazwie już istnieje!");
        }

        // Szyfruj hasło
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        // Nadaj rolę użytkownika (np. "ROLE_USER")
        user.setRole("ROLE_USER");

        userRepository.save(user);

        return ResponseEntity.ok("Użytkownik zarejestrowany pomyślnie!");
    }
}