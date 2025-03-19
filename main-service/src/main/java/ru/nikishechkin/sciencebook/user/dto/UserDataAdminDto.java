package ru.nikishechkin.sciencebook.user.dto;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import ru.nikishechkin.sciencebook.organization.Organization;

@Data
public class UserDataAdminDto {
    Long id;
    String email;
    String password;
    String name;
    Organization organization;
}
