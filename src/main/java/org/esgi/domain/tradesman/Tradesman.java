package org.esgi.domain.tradesman;

import org.esgi.domain.Password;
import org.esgi.domain.address.Address;
import org.esgi.domain.creditcard.CreditCard;
import org.esgi.domain.creditcard.CreditCardBuilder;

public class Tradesman {
    private final TradesmanId tradesmanId;
    private String firstName;
    private String lastName;
    private Password password;
    private Address address;
    private CreditCard creditCard;

    public Tradesman(TradesmanId tradesmanId, String firstName, String lastName, Password password, Address address, CreditCard creditCard) {
        this.tradesmanId = tradesmanId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.address = address;
        this.creditCard = creditCard;
    }

    public static Tradesman of(TradesmanId tradesmanId, String firstName, String lastName, Address address, CreditCard creditCard, Password password){
        return new Tradesman(tradesmanId, firstName, lastName, password, address, creditCard);
    }

    @Override
    public String toString(){
        return "Tradesman:{ " +
                "TradesmanId: " + this.tradesmanId + ", " +
                "FirstName: " + this.firstName + ", " +
                "LastName: " + this.lastName + ", " +
                this.address.toString() + ", " +
                "Password: " + this.password.getValue() + ", " +
                this.creditCard.toString() + " }";
    }

    public TradesmanId getTradesmanId() {
        return this.tradesmanId;
    }

    public Password getPassword() {
        return password;
    }

    public void setPassword(Password password) {
        this.password = password;
    }

    public CreditCard getCreditCard() {
        return this.creditCard;
    }

    public void setCreditCard(CreditCard creditCard) {
        this.creditCard = creditCard;
    }

    public Address getAddress(){
        return this.address;
    }

    public void setAddress(Address address){
        this.address = this.address.changeAddress(address);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
