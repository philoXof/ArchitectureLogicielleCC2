package org.esgi.domain.creditcard;

import java.util.Date;

public class DefaultCreditCard implements CreditCard{

    private final String cardNumber;
    private final Date expirationDate;
    private final String owner;
    private final String cryptogram;

    public DefaultCreditCard(String cardNumber, Date expirationDate, String owner, String cryptogram) {
        this.cardNumber = cardNumber;
        this.expirationDate = expirationDate;
        this.owner = owner;
        this.cryptogram = cryptogram;
    }

    @Override
    public String cardNumber() {
        return this.cardNumber;
    }

    @Override
    public Date expirationDate() {
        return this.expirationDate;
    }

    @Override
    public String owner() {
        return this.owner;
    }

    @Override
    public String cryptogram() {
        return this.cryptogram;
    }

    @Override
    public String toString(){
        return "CreditCard: { " +
                "CardNumber: " + this.cardNumber + ", " +
                "ExpirationDate: " + this.expirationDate + ", " +
                "Owner: " + this.owner + ", " +
                "Cryptogram: " + this.cryptogram + " }";
    }

}
