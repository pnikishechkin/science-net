package ru.nikishechkin.sciencebook.user.dto;

import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Data
public class UserCreateDto {
    @NotNull
    @NotBlank
    @Email
    private String email;

    @NotNull
    @NotBlank
    @Length(min = 5, max = 20, message = "Пароль должен быть длиной от 5 до 20 символов")
    private String password;

    @NotNull
    @NotBlank
    private String name;

    private Long organizationId;
}
