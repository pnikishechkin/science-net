package ru.nikishechkin.sciencebook.user;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.nikishechkin.sciencebook.user.dto.UserCreateDto;

@Mapper
public interface UserMapper {

    // MapStruct: https://www.baeldung.com/mapstruct

    @Mapping(target = "email", source = "entity.email")
    @Mapping(target = "name", source = "entity.name")
    UserCreateDto userToUserCreateDto(User entity);

    @Mapping(target = "email", source = "dto.email")
    @Mapping(target = "name", source = "dto.name")
    User userCreateDtoToUser(UserCreateDto dto);
}
