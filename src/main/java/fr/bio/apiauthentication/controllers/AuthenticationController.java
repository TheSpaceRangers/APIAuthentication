package fr.bio.apiauthentication.controllers;

import fr.bio.apiauthentication.dto.AuthenticationRequest;
import fr.bio.apiauthentication.dto.AuthenticationResponse;
import fr.bio.apiauthentication.dto.CreateUserRequest;
import fr.bio.apiauthentication.services.IAuthenticationService;

import lombok.RequiredArgsConstructor;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/auth")
public class AuthenticationController {
    private final IAuthenticationService authenticationService;

    @PostMapping(value = "/register", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AuthenticationResponse> register (
            @Validated @RequestBody CreateUserRequest request
    ) {
        return authenticationService.register(request);
    }

    @PostMapping(value = "/login", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AuthenticationResponse> login (
            @Validated @RequestBody AuthenticationRequest request
    ) {
        return authenticationService.login(request);
    }
}
