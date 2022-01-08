package org.esgi.use_case.contractor.domain;

import org.esgi.domain.Email;
import org.esgi.domain.Password;
import org.esgi.domain.creditcard.CreditCard;
import org.esgi.use_case.project.domain.ProjectId;

import java.util.ArrayList;
import java.util.List;

public class Contractor {
    private final ContractorId id;
    private String firstName;
    private String lastName;
    private Password password;
    private Email email;
    private CreditCard creditCard;
    private List<ProjectId> projects;
    private boolean isValid;


    public Contractor(ContractorId id, String firstName, String lastName, Password password, Email email, CreditCard creditCard) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.email = email;
        this.creditCard = creditCard;
        this.projects = new ArrayList();
        this.isValid = false;
    }

    public static Contractor of(ContractorId id, String firstName, String lastName, Password password, Email email, CreditCard creditCard){
        return new Contractor(id, firstName, lastName, password, email, creditCard);
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

    public Email getEmail() {
        return email;
    }

    public void setEmail(Email email) {
        this.email = email;
    }

    public CreditCard getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(CreditCard creditCard) {
        this.creditCard = creditCard;
    }

    public List<ProjectId> getProjects() {
        return projects;
    }

    public void addProject(ProjectId id) {
        this.projects.add(id);
    }

    public void deleteProject(ProjectId id){
        this.projects.remove(id);
    }

    public boolean isValid() {
        return isValid;
    }

    public void setValid() {
        isValid = true;
    }

    public void setInvalid(){
        isValid = false;
    }
}
