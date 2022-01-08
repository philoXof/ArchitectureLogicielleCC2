package org.esgi.use_case.contractor.domain;

import org.esgi.use_case.project.domain.ProjectId;

import java.util.List;

public interface ContractorRepository {
    void add(Contractor contractor);

    ContractorId nextIdentity();

    List<Contractor> findAll();

    Contractor findById(ContractorId id);

    void save(Contractor contractor);

    void addProject(ContractorId id, ProjectId projectId);

    void deleteProject(ContractorId id, ProjectId projectId);

    void setValid(ContractorId id);

    void setInvalid(ContractorId id);
}
