package org.esgi.application;

import org.esgi.kernel.ApplicationEvent;

import java.util.Date;
import java.util.Objects;

public class TradesmanAddCreditCard implements ApplicationEvent {

    private final String cardNumber;
    private final Date expirationDate;
    private final String owner;
    private final String cryptogram;

    public TradesmanAddCreditCard(String cardNumber, Date expirationDate, String owner, String cryptogram) {
        this.cardNumber = cardNumber;
        this.expirationDate = expirationDate;
        this.owner = owner;
        this.cryptogram = cryptogram;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TradesmanAddCreditCard that = (TradesmanAddCreditCard) o;
        return Objects.equals(cardNumber, that.cardNumber) && Objects.equals(expirationDate, that.expirationDate) && Objects.equals(owner, that.owner) && Objects.equals(cryptogram, that.cryptogram);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cardNumber, expirationDate, owner, cryptogram);
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public String getOwner() {
        return owner;
    }

    public String getCryptogram() {
        return cryptogram;
    }
}
