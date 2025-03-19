package ru.nikishechkin.sciencebook.user;

import ru.nikishechkin.sciencebook.user.dto.UserAuthorizeDto;
import ru.nikishechkin.sciencebook.user.dto.UserCreateDto;
import ru.nikishechkin.sciencebook.user.dto.UserDataAdminDto;

import java.util.List;

public interface UserService {

    User create(UserCreateDto userCreateDto);

    void delete(Long userId);

    UserDataAdminDto getUserByIdAdmin(Long userId);

    List<User> getUsersAdmin(List<Long> ids, Integer from, Integer size);

    User authorize(UserAuthorizeDto userAuthorizeDto);
}
