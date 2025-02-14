package ru.nikishechkin.sciencebook.user;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import ru.nikishechkin.sciencebook.user.dto.UserCreateDto;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Validated
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    //private final UserMapper userMapper;

    @Override
    public User create(UserCreateDto userCreateDto) {
        // User user = userMapper.userCreateDtoToUser(userCreateDto);
        // TODO organization проверка на валидность
        User user = null;
        userRepository.save(user);
        return user;
    }

    @Override
    public void delete(Long userId) {
        userRepository.deleteById(userId);
    }

    @Override
    public Optional<User> getById(Long userId) {
        return userRepository.findById(userId);
    }

    @Override
    public List<User> getAll(List<Long> ids, Integer from, Integer size) {
        return List.of();
    }

    // Другой вариант маппинга, используя ModelMapper
    // https://sysout.ru/preobrazovanie-entity-v-dto-s-pomoshhyu-modelmapper/
    // https://www.baeldung.com/entity-to-and-from-dto-for-a-java-spring-application
    // https://habr.com/ru/articles/438808/
    private User convertToEntity(UserCreateDto userCreateDto) {
        User user = modelMapper.map(userCreateDto, User.class);
        return user;
    }
}
