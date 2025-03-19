package ru.nikishechkin.sciencebook.user;

import lombok.RequiredArgsConstructor;
import org.aspectj.lang.annotation.After;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;
import ru.nikishechkin.sciencebook.config.SecurityConfig;
import ru.nikishechkin.sciencebook.user.dto.UserCreateDto;
import ru.nikishechkin.sciencebook.user.dto.UserDataAdminDto;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public abstract class UserMapper {

    // MapStruct: https://www.baeldung.com/mapstruct

    //UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    //@Mapping(target = "email", source = "entity.email")
    //@Mapping(target = "name", source = "entity.name")
    abstract UserCreateDto userToUserCreateDto(User entity);

    //@Mapping(target = "email", source = "dto.email")
    //@Mapping(target = "name", source = "dto.name")
    abstract User userCreateDtoToUser(UserCreateDto dto);

    abstract UserDataAdminDto userToUserAdminDto(User entity);

    @AfterMapping
    protected void convertPassword(@MappingTarget UserDataAdminDto userDataAdminDto) {
        // Дополнительные действия после маппинга
    }
}
