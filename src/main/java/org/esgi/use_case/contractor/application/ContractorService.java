package org.esgi.use_case.contractor.application;

import org.esgi.domain.Password;
import org.esgi.domain.creditcard.CreditCard;
import org.esgi.kernel.ApplicationEvent;
import org.esgi.kernel.EventBus;
import org.esgi.use_case.contractor.domain.Contractor;
import org.esgi.use_case.contractor.domain.ContractorId;
import org.esgi.use_case.contractor.domain.ContractorRepository;
import org.esgi.use_case.project.domain.ProjectId;

import java.util.List;

public final class ContractorService {

    private final ContractorRepository contractorRepository;
    private final EventBus<ApplicationEvent> eventBus;

    public ContractorService(ContractorRepository contractorRepository, EventBus<ApplicationEvent> eventBus) {
        this.contractorRepository = contractorRepository;
        this.eventBus = eventBus;
    }

    public void create(Contractor contractor){
        this.contractorRepository.add(contractor);
        this.eventBus.publish(new CreateContractorEvent(contractor));
    }

    public void changeCreditCard(ContractorId id, CreditCard creditCard){
        var contractor = this.contractorRepository.findById(id);
        contractor.setCreditCard(creditCard);
        this.contractorRepository.save(contractor);
    }

    public void changePassword(ContractorId id, Password password){
        var contractor = this.contractorRepository.findById(id);
        contractor.setPassword(password);
        this.contractorRepository.save(contractor);
    }

    public void addProject(ContractorId id, ProjectId projectId){
        this.contractorRepository.addProject(id, projectId);
    }

    public void deleteProject(ContractorId id, ProjectId projectId){
        this.contractorRepository.deleteProject(id, projectId);
    }

    public List<Contractor> all(){
        return this.contractorRepository.findAll();
    }
}
