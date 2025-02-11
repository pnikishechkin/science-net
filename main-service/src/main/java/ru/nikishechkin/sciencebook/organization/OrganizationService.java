package ru.nikishechkin.sciencebook.organization;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrganizationService {

    private final OrganizationRepository organizationRepository;
/*
    public OrganizationService(OrganizationRepository organizationRepository) {
        this.organizationRepository = organizationRepository;

        Organization or = new Organization();
        or.setId(5L);
    }
*/

}
