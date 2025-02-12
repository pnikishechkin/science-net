package ru.nikishechkin.sciencebook.user;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    //Optional<User> findById(Long id);

    List<User> findAllByIdIn(List<Long> ids, Pageable pageable);

}
