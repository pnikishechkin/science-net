package ru.nikishechkin.sciencebook.user;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.nikishechkin.sciencebook.user.dto.UserCreateDto;

import java.util.List;

@RestController
@RequestMapping("/admin/users")
@RequiredArgsConstructor
@Slf4j
@Validated
public class UserControllerAdmin {

    private final UserServiceImpl userService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public User create(@RequestBody @Validated UserCreateDto userDto) {
        // TODO validation exception
        return userService.create(userDto);
    }

    @GetMapping
    public List<User> getUsers(@RequestParam(required = false) List<Long> ids,
                             @RequestParam(defaultValue = "0") Integer pageNumber,
                             @RequestParam(defaultValue = "10") Integer pageSize) {
        return userService.getUsers(ids, pageNumber, pageSize);
    }

    @GetMapping("/{userId}")
    public User getUser(@PathVariable Long userId) {
        return userService.getById(userId);
    }
}
