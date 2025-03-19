package ru.nikishechkin.sciencebook.user;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import ru.nikishechkin.sciencebook.config.SecurityConfig;
import ru.nikishechkin.sciencebook.exception.AuthorizeException;
import ru.nikishechkin.sciencebook.exception.NotFoundException;
import ru.nikishechkin.sciencebook.organization.Organization;
import ru.nikishechkin.sciencebook.organization.OrganizationRepository;
import ru.nikishechkin.sciencebook.user.dto.UserAuthorizeDto;
import ru.nikishechkin.sciencebook.user.dto.UserCreateDto;
import ru.nikishechkin.sciencebook.user.dto.UserDataAdminDto;

import java.util.List;

@Service
@RequiredArgsConstructor
@Validated
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final OrganizationRepository organizationRepository;
    private final SecurityConfig securityConfig;

    @Override
    public User create(UserCreateDto userCreateDto) {
        User user = userMapper.userCreateDtoToUser(userCreateDto);
        if (userCreateDto.getOrganizationId() != null) {
            Organization organization = organizationRepository.findById(userCreateDto.getOrganizationId())
                    .orElseThrow(() -> new NotFoundException("Указана несуществующая организация"));
            user.setOrganization(organization);
        }
        user.setPassword(securityConfig.passwordEncoder().encode(userCreateDto.getPassword()));
        userRepository.save(user);
        return user;
    }

    @Override
    public void delete(Long userId) {
        getUserByIdAdmin(userId);
        userRepository.deleteById(userId);
    }

    @Override
    public UserDataAdminDto getUserByIdAdmin(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(() ->
                new NotFoundException("Пользователя с заданным идентификатором не существует!"));

        return userMapper.userToUserAdminDto(user);
    }

    @Override
    public List<User> getUsersAdmin(List<Long> ids, Integer pageNumber, Integer pageSize) {
        if (ids == null) {
            return userRepository.findAll(PageRequest.of(pageNumber, pageSize)).toList();
        } else {
            return userRepository.findAllByIdIn(ids, PageRequest.of(pageNumber, pageSize));
        }
    }

    @Override
    public User authorize(UserAuthorizeDto userAuthorizeDto) {
        // Результаты: успех / е-меил не найден / пароль неверный
        User user = userRepository.findByEmail(userAuthorizeDto.getEmail()).orElseThrow(() -> new NotFoundException(
                "Пользователя с указанным e-mail не существует!"));

        if (!securityConfig.passwordEncoder().matches(userAuthorizeDto.getPassword(),
                user.getPassword())) {
            throw new AuthorizeException("Указан неверный пароль!");
        }

        return user; // TODO возвращать токен JWT
    }

    // Другой вариант маппинга, используя ModelMapper
    // https://sysout.ru/preobrazovanie-entity-v-dto-s-pomoshhyu-modelmapper/
    // https://www.baeldung.com/entity-to-and-from-dto-for-a-java-spring-application
    // https://habr.com/ru/articles/438808/
//    private User convertToEntity(UserCreateDto userCreateDto) {
//        User user = modelMapper.map(userCreateDto, User.class);
//        return user;
//    }
}
