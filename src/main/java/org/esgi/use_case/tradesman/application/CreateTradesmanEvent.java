package org.esgi.use_case.tradesman.application;

import org.esgi.use_case.tradesman.domain.Tradesman;
import org.esgi.kernel.ApplicationEvent;

import java.util.Objects;

public class CreateTradesmanEvent implements ApplicationEvent {
    private final TradesmanId id;
    private final String firstName;
    private final String lastName;
    private final Password password;
    private final Address address;
    private final CreditCard creditCard;

    public CreateTradesmanEvent(TradesmanId id, String firstName, String lastName, Password password, Address address, CreditCard creditCard) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.address = address;
        this.creditCard = creditCard;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CreateTradesmanEvent that = (CreateTradesmanEvent) o;
        return Objects.equals(tradesman, that.tradesman);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tradesman);
    }

    public Tradesman getTradesman(){
        return tradesman;
    }
}
