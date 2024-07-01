package fr.bio.apiauthentication.dto.authentication;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record RegisterRequest(
        @NotNull @NotBlank String firstName,
        @NotNull @NotBlank String lastName,
        @NotNull @NotBlank @Email String email,
        @NotNull @NotBlank String password
) {
}