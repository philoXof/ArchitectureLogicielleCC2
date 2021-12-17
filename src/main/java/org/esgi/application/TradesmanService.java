package org.esgi.application;

import org.esgi.domain.Password;
import org.esgi.domain.address.Address;
import org.esgi.domain.creditcard.CreditCard;
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
        CreditCard creditCard = tradesman.getCreditCard();
        this.eventBus.publish(new TradesmanAddCreditCard(
                creditCard.cardNumber(),
                creditCard.expirationDate(),
                creditCard.owner(),
                creditCard.cryptogram()
        ));
        this.eventBus.publish(new CreateTradesmanEvent(
                tradesman.getId(),
                tradesman.getFirstName(),
                tradesman.getLastName(),
                tradesman.getPassword(),
                tradesman.getAddress(),
                tradesman.getCreditCard()
        ));
    }

    public void changeAddress(TradesmanId id, Address address){
        var tradesman = this.tradesmanRepository.findById(id);
        tradesman.setAddress(address);
        this.tradesmanRepository.save(tradesman);
    }

    public void changeCreditCard(TradesmanId id, CreditCard creditCard){
        var tradesman = this.tradesmanRepository.findById(id);
        tradesman.setCreditCard(creditCard);
        this.tradesmanRepository.save(tradesman);
    }

    public void changePassword(TradesmanId id, Password password){
        var tradesman = this.tradesmanRepository.findById(id);
        tradesman.setPassword(password);
        this.tradesmanRepository.save(tradesman);
    }

    public List<Tradesman> all(){
        return this.tradesmanRepository.findAll();
    }

}
