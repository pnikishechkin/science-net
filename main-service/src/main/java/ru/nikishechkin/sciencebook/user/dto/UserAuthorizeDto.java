package ru.nikishechkin.sciencebook.user.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class UserAuthorizeDto {
    @NotNull
    @NotBlank
    @Email
    String email;

    @NotNull
    @NotBlank
    String password;
}
