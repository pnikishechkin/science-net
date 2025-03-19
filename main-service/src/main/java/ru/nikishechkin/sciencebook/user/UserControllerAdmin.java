package ru.nikishechkin.sciencebook.user;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.nikishechkin.sciencebook.user.dto.UserDataAdminDto;

import java.util.List;

@RestController
@RequestMapping("/admin/users")
@RequiredArgsConstructor
@Slf4j
@Validated
public class UserControllerAdmin {

    private final UserServiceImpl userService;

    @GetMapping
    public List<User> getUsers(@RequestParam(required = false) List<Long> ids,
                             @RequestParam(defaultValue = "0") Integer pageNumber,
                             @RequestParam(defaultValue = "10") Integer pageSize) {
        return userService.getUsersAdmin(ids, pageNumber, pageSize);
    }

    @GetMapping("/{userId}")
    public UserDataAdminDto getUser(@PathVariable Long userId) {
        return userService.getUserByIdAdmin(userId);
    }
}
