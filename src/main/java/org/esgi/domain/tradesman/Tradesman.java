package org.esgi.domain.tradesman;

import org.esgi.domain.address.Address;

public class Tradesman {
    private final TradesmanId tradesmanId;
    private String firstName;
    private String lastName;
    private Address address;

    public Tradesman(TradesmanId tradesmanId, String firstName, String lastName, Address address) {
        this.tradesmanId = tradesmanId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;

    }

    public static Tradesman of(TradesmanId tradesmanId, String firstName, String lastName, Address address){
        return new Tradesman(tradesmanId, firstName, lastName, address);
    }

    @Override
    public String toString(){
        return "Tradesman:{ " +
                "TradesmanId: " + this.tradesmanId + ", " +
                "FirstName: " + this.firstName + ", " +
                "LastName: " + this.lastName + ", " +
                this.address.toString() + " }";
    }

    public TradesmanId getTradesmanId() {
        return this.tradesmanId;

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
