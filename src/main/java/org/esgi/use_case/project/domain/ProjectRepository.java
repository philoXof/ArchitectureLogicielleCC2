package org.esgi.use_case.project.domain;

import org.esgi.use_case.contractor.domain.ContractorId;
import org.esgi.use_case.tradesman.domain.Tradesman;

import java.util.List;

public interface ProjectRepository {
    void add(Project project);

    ProjectId nextIdentity();

    Project findById(ProjectId id);

    void save(Project project);

    List<ProjectId> findAllByContractor(ContractorId id);

    void setValid(ProjectId id);

    void setInvalid(ProjectId id);
}
