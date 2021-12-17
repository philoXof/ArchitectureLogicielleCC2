package org.esgi.domain.contractor;

import org.esgi.domain.Password;

public class Contractor {
    private final ContractorId id;
    private String firstName;
    private String lastName;
    private Password password;

    public Contractor(ContractorId id, String firstName, String lastName, Password password) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
    }

    public static Contractor of(ContractorId id, String firstName, String lastName, Password password){
        return new Contractor(id, firstName, lastName, password);
    }

    @Override
    public String toString(){
        return "Contractor:{ " +
                "Id: " + this.id + ", " +
                "FirstName: " + this.firstName + ", " +
                "LastName: " + this.lastName + ", " +
                "Password: " + this.password.getValue() + " }";
    }

    public ContractorId getId() {
        return id;
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

    public Password getPassword() {
        return password;
    }

    public void setPassword(Password password) {
        this.password = password;
    }
}
