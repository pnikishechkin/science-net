package ru.nikishechkin.sciencebook.user;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.nikishechkin.sciencebook.user.dto.UserCreateDto;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
@Slf4j
@Validated
public class UserControllerPublic {
    private final UserServiceImpl userService;

    @PostMapping("/register")
    public void register(@RequestBody @Validated UserCreateDto userCreateDto) {

    }

    // TODO login
}
