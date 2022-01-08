package org.esgi;

import org.esgi.use_case.tradesman.application.CreateTradesmanEvent;
import org.esgi.kernel.EventListener;
import org.esgi.use_case.tradesman.domain.TradesmanRepository;
import org.esgi.use_case.tradesman.domain.TradesmanValidator;

public class CreateTradesmanEventListener implements EventListener<CreateTradesmanEvent> {
    private final TradesmanRepository tradesmanRepository;

    public CreateTradesmanEventListener(TradesmanRepository tradesmanRepository){
        this.tradesmanRepository = tradesmanRepository;
    }

    @Override
    public void listenTo(CreateTradesmanEvent event) {
        final TradesmanValidator validator = new TradesmanValidator();
        if(validator.isValid(event.getTradesman())) {
            tradesmanRepository.setValid(event.getTradesman().getId());
            System.out.println("Checking Credit card for payment...");
        } else tradesmanRepository.setInvalid(event.getTradesman().getId());
    }
}
