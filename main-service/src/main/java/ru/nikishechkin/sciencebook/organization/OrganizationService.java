package ru.nikishechkin.sciencebook.organization;

import java.util.List;

public interface OrganizationService {
    List<Organization> getOrganizations(List<Long> ids, Integer pageNumber, Integer pageSize);
}
