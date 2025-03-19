package ru.nikishechkin.sciencebook.organization;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/organizations")
@RequiredArgsConstructor
@Slf4j
@Validated
public class OrganizationController {
    private final OrganizationService organizationService;

    @GetMapping
    public List<Organization> getOrganizations(@RequestParam(required = false) List<Long> ids,
                                               @RequestParam(defaultValue = "0") Integer pageNumber,
                                               @RequestParam(defaultValue = "10") Integer pageSize) {
        return organizationService.getOrganizations(ids, pageNumber, pageSize);
    }
}
