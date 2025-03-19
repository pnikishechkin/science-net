package ru.nikishechkin.sciencebook.user;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.validator.constraints.Length;
import ru.nikishechkin.sciencebook.organization.Organization;

@Entity
@Table(name = "users")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "email", unique = true, nullable = false)
    @Length(min = 6, max = 254)
    @Email
    String email;

    @NotNull
    @NotBlank
    private String password;

    @Column(name = "name", nullable = false)
    @Length(min = 2, max = 250)
    String name;

    @ManyToOne
    @JoinColumn(name = "organization_id")
    Organization organization;
}
