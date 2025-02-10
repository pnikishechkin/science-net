package ru.nikishechkin.sciencebook.user;

import jakarta.persistence.criteria.CriteriaBuilder;

import java.util.List;

public interface UserService {
    List<User> getAll(List<Long> ids, Integer from, Integer size);
}
