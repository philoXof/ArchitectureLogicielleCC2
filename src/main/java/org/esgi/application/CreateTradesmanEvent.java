package org.esgi.application;

import org.esgi.domain.address.Address;
import org.esgi.domain.tradesman.TradesmanId;
import org.esgi.kernel.ApplicationEvent;

public class CreateTradesmanEvent implements ApplicationEvent {
    private final TradesmanId tradesmanId;
    private String firstName;
    private String lastName;
    private Address address;

    public CreateTradesmanEvent(TradesmanId tradesmanId, String firstName, String lastName, Address address) {
        this.tradesmanId = tradesmanId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
    }
}
