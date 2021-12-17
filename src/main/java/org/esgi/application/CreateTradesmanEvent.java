package org.esgi.application;

import org.esgi.domain.Password;
import org.esgi.domain.address.Address;
import org.esgi.domain.creditcard.CreditCard;
import org.esgi.domain.tradesman.TradesmanId;
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
        return Objects.equals(id, that.id) && Objects.equals(firstName, that.firstName) && Objects.equals(lastName, that.lastName) && Objects.equals(password, that.password) && Objects.equals(address, that.address) && Objects.equals(creditCard, that.creditCard);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, password, address, creditCard);
    }

    public TradesmanId getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Password getPassword() {
        return password;
    }

    public Address getAddress() {
        return address;
    }

    public CreditCard getCreditCard() {
        return creditCard;
    }
}
