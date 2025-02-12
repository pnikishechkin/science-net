package ru.nikishechkin.sciencebook.user.dto;

import lombok.Data;
import ru.nikishechkin.sciencebook.organization.Organization;

@Data
public class UserCreateDto {
    String email;
    String name;
    Organization organization;
}
