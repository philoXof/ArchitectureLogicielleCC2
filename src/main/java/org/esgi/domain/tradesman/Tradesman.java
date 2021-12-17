package org.esgi.domain.tradesman;

import org.esgi.domain.Password;
import org.esgi.domain.address.Address;
import org.esgi.domain.creditcard.CreditCard;

public class Tradesman {
    private final TradesmanId id;
    private String firstName;
    private String lastName;
    private Password password;
    private Address address;
    private CreditCard creditCard;
    //private String skills;
    //zone géographique
    // taux journalier
    // certificat d'aptitude

    public Tradesman(TradesmanId id, String firstName, String lastName, Password password, Address address, CreditCard creditCard) {
        this.id = id;
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
                "Id: " + this.id + ", " +
                "FirstName: " + this.firstName + ", " +
                "LastName: " + this.lastName + ", " +
                this.address.toString() + ", " +
                "Password: " + this.password.getValue() + ", " +
                this.creditCard.toString() + " }";
    }

    public TradesmanId getId() {
        return this.id;
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
