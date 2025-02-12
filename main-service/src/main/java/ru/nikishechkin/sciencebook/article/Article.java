package ru.nikishechkin.sciencebook.article;

import jakarta.persistence.*;
import lombok.Data;
import ru.nikishechkin.sciencebook.user.User;

import java.util.List;

@Entity
@Table(name = "articles")
@Data
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "filepath")
    private String filepath;

    @ManyToMany
    private List<User> authors;
}
