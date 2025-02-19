package ru.nikishechkin.sciencebook.user;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import ru.nikishechkin.sciencebook.exception.NotFoundException;
import ru.nikishechkin.sciencebook.organization.Organization;
import ru.nikishechkin.sciencebook.organization.OrganizationRepository;
import ru.nikishechkin.sciencebook.user.dto.UserCreateDto;

import java.util.List;

@Service
@RequiredArgsConstructor
@Validated
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final OrganizationRepository organizationRepository;

    @Override
    public User create(UserCreateDto userCreateDto) {
        User user = userMapper.userCreateDtoToUser(userCreateDto);
        if (userCreateDto.getOrganizationId() != null) {
            Organization organization = organizationRepository.findById(userCreateDto.getOrganizationId())
                    .orElseThrow(() -> new NotFoundException("Указана несуществующая организация"));
            user.setOrganization(organization);
        }
        userRepository.save(user);
        return user;
    }

    @Override
    public void delete(Long userId) {
        getById(userId);
        userRepository.deleteById(userId);
    }

    @Override
    public User getById(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(() ->
                new NotFoundException("Пользователя с заданным идентификатором не существует!"));
        // TODO Объекты dto
        return user;
    }

    @Override
    public List<User> getAll(List<Long> ids, Integer pageNumber, Integer pageSize) {
        if (ids == null) {
            return userRepository.findAll(PageRequest.of(pageNumber, pageSize)).toList();
        } else {
            return userRepository.findAllByIdIn(ids, PageRequest.of(pageNumber, pageSize)).stream().toList();
        }
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
