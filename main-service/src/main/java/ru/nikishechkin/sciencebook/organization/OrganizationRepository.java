package ru.nikishechkin.sciencebook.organization;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrganizationRepository extends JpaRepository<Organization, Long> {
    List<Organization> findAllByIdIn(List<Long> ids, Pageable pageable);
}
