package org.esgi;

import org.esgi.kernel.EventListener;
import org.esgi.use_case.contractor.application.CreateContractorEvent;
import org.esgi.use_case.contractor.domain.ContractorRepository;
import org.esgi.use_case.contractor.domain.ContractorValidator;

public class CreateContractorEventListener implements EventListener<CreateContractorEvent> {
    private final ContractorRepository contractorRepository;

    public CreateContractorEventListener(ContractorRepository contractorRepository) {
        this.contractorRepository = contractorRepository;
    }

    @Override
    public void listenTo(CreateContractorEvent event) {
        final ContractorValidator validator = new ContractorValidator();
        if(validator.isValid(event.getContractor())) {
            contractorRepository.setValid(event.getContractor().getId());
            System.out.println("Checking creditCard for payment...");
        } else contractorRepository.setInvalid(event.getContractor().getId());
    }
}
