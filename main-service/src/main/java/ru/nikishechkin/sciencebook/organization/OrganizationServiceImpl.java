package ru.nikishechkin.sciencebook.organization;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrganizationServiceImpl implements OrganizationService {

    private final OrganizationRepository organizationRepository;

    @Override
    public List<Organization> getOrganizations(List<Long> ids, Integer pageNumber, Integer pageSize) {
        if (ids == null) {
            return organizationRepository.findAll(PageRequest.of(pageNumber, pageSize)).toList();
        } else {
            return organizationRepository.findAllByIdIn(ids, PageRequest.of(pageNumber, pageSize));
        }
    }
}
