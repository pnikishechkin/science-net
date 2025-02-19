package ru.nikishechkin.sciencebook.user;

import ru.nikishechkin.sciencebook.user.dto.UserCreateDto;

import java.util.List;
import java.util.Optional;

public interface UserService {

    User create(UserCreateDto userCreateDto);

    void delete(Long userId);

    User getById(Long userId);

    List<User> getAll(List<Long> ids, Integer from, Integer size);
}
