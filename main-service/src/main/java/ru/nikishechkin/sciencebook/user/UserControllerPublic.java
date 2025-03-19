package ru.nikishechkin.sciencebook.user;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.nikishechkin.sciencebook.user.dto.UserAuthorizeDto;
import ru.nikishechkin.sciencebook.user.dto.UserCreateDto;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
@Slf4j
@Validated
public class UserControllerPublic {
    private final UserServiceImpl userService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public User create(@RequestBody @Validated UserCreateDto userDto) {
        return userService.create(userDto);
    }

    // User Authorize with Spring Security

    @PostMapping("/login")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public User authorize(@RequestBody @Validated UserAuthorizeDto userAuthorizeDto) {
        return userService.authorize(userAuthorizeDto);
    }
}
