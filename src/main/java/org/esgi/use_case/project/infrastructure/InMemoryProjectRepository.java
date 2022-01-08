package org.esgi.use_case.project.infrastructure;

import org.esgi.use_case.contractor.domain.ContractorId;
import org.esgi.use_case.contractor.domain.ContractorRepository;
import org.esgi.use_case.contractor.infrastructure.InMemoryContractorRepository;
import org.esgi.use_case.project.domain.Project;
import org.esgi.use_case.project.domain.ProjectId;
import org.esgi.use_case.project.domain.ProjectRepository;
import org.esgi.use_case.contractor.domain.Contractor;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public final class InMemoryProjectRepository implements ProjectRepository {

    private final AtomicInteger counter = new AtomicInteger(0);
    private final Map<ProjectId, Project> data = new HashMap<>();

    @Override
    public void add(Project project) {
        data.put(project.getId(), project);
    }

    @Override
    public ProjectId nextIdentity() {
        return ProjectId.of(counter.incrementAndGet());
    }

    @Override
    public Project findById(ProjectId id) {
        final Project project = data.get(id);
        if(project == null){
            throw new RuntimeException("No project for " + id.getValue());
        }
        return project;
    }

    @Override
    public void save(Project project) {
        data.put(project.getId(),project);
    }

    @Override
    public List<ProjectId> findAllByContractor(ContractorId id) {
        final ContractorRepository contractorRepository = new InMemoryContractorRepository();
        final Contractor contractor = contractorRepository.findById(id);
        return contractor.getProjects();
    }

    @Override
    public void setValid(ProjectId id) {
        final Project project = findById(id);
        project.setValid();
        save(project);
    }

    @Override
    public void setInvalid(ProjectId id) {
        final Project project = findById(id);
        project.setInvalid();
        save(project);
    }


}
