package ru.nikishechkin.sciencebook.user;

import lombok.NonNull;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.nikishechkin.sciencebook.user.dto.UserCreateDto;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    //Optional<User> findById(Long id);

    List<User> findAllByIdIn(List<Long> ids, Pageable pageable);

}
