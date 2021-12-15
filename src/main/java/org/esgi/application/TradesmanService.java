package org.esgi.application;

import org.esgi.domain.address.Address;
import org.esgi.domain.tradesman.Tradesman;
import org.esgi.domain.tradesman.TradesmanId;
import org.esgi.domain.tradesman.TradesmanRepository;
import org.esgi.kernel.ApplicationEvent;
import org.esgi.kernel.EventBus;

import java.util.List;

public class TradesmanService {

    private final TradesmanRepository tradesmanRepository;
    private final EventBus<ApplicationEvent> eventBus;



    public TradesmanService(TradesmanRepository tradesmanRepository, EventBus<ApplicationEvent> eventBus) {
        this.tradesmanRepository = tradesmanRepository;
        this.eventBus = eventBus;
    }

    public void create(Tradesman tradesman) {
        this.tradesmanRepository.add(tradesman);
        this.eventBus.publish(new CreateTradesmanEvent(
                tradesman.getTradesmanId(),
                tradesman.getFirstName(),
                tradesman.getFirstName(),
                tradesman.getAddress()
                ));
    }

    public void changeAddress(TradesmanId id, Address address){
        var user = this.tradesmanRepository.findById(id);
        user.setAddress(address);
        this.tradesmanRepository.save(user);
    }

    public List<Tradesman> all(){
        return this.tradesmanRepository.findAll();
    }

}
