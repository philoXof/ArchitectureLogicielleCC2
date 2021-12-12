package org.esgi.domain.user;

import org.esgi.domain.address.Address;

public class User {
    private final UserId userId;
    private String firstName;
    private String lastName;
    private Address address;

    public User(UserId userId, String firstName, String lastName, Address address) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
    }

    public static User of(UserId userId, String firstName, String lastName, Address address){
        return new User(userId, firstName, lastName, address);
    }

    @Override
    public String toString(){
        return "User:{ " +
                "userId: " + this.userId + ", " +
                "firstName: " + this.firstName + ", " +
                "lastName: " + this.lastName + ", " +
                this.address.toString() + " }";
    }

    public UserId getUserId() {
        return userId;
    }

    public Address getAddress(){
        return this.address;
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
