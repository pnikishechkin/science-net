package ru.nikishechkin.sciencebook.user;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import ru.nikishechkin.sciencebook.user.dto.UserCreateDto;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface UserMapper {

    // MapStruct: https://www.baeldung.com/mapstruct

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mapping(target = "email", source = "entity.email")
    @Mapping(target = "name", source = "entity.name")
    UserCreateDto userToUserCreateDto(User entity);

    @Mapping(target = "email", source = "dto.email")
    @Mapping(target = "name", source = "dto.name")
    User userCreateDtoToUser(UserCreateDto dto);
}
