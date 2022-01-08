package org.esgi.use_case.contractor.infrastructure;

import org.esgi.use_case.contractor.domain.Contractor;
import org.esgi.use_case.contractor.domain.ContractorId;
import org.esgi.use_case.contractor.domain.ContractorRepository;
import org.esgi.use_case.project.domain.ProjectId;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public final class InMemoryContractorRepository implements ContractorRepository {

    private final AtomicInteger counter = new AtomicInteger(0);
    private final Map<ContractorId, Contractor> data = new HashMap<>();

    @Override
    public void add(Contractor contractor) {
        AtomicBoolean emailExist = new AtomicBoolean(false);
        List<Contractor> contractors = findAll();
        contractors.forEach(list -> {
            if (list.getEmail().equals(contractor.getEmail())){
                emailExist.set(true);
            }
        });
        if(emailExist.get()){
            System.out.println("Email already exist.");
        }else {
            data.put(contractor.getId(), contractor);
        }
    }

    @Override
    public ContractorId nextIdentity() {
        return ContractorId.of(counter.incrementAndGet());
    }

    @Override
    public List<Contractor> findAll() {
        return new ArrayList<>(data.values());
    }

    @Override
    public Contractor findById(ContractorId id) {
        final Contractor contractor = data.get(id);
        if(contractor == null){
            throw new RuntimeException("No contractor for " + id.getValue());
        }
        return contractor;
    }

    @Override
    public void save(Contractor contractor) {
        data.put(contractor.getId(), contractor);
    }

    @Override
    public void addProject(ContractorId id, ProjectId projectId) {
        final Contractor contractor = findById(id);
        contractor.addProject(projectId);
        save(contractor);
    }

    @Override
    public void deleteProject(ContractorId id, ProjectId projectId) {
        final Contractor contractor = findById(id);
        contractor.deleteProject(projectId);
        save(contractor);
    }

    @Override
    public void setValid(ContractorId id) {
        final Contractor contractor = findById(id);
        contractor.setValid();
        save(contractor);
    }

    @Override
    public void setInvalid(ContractorId id) {
        final Contractor contractor = findById(id);
        contractor.setInvalid();
        save(contractor);
    }
}
