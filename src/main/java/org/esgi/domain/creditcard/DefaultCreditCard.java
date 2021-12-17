package org.esgi.domain.creditcard;

import java.text.SimpleDateFormat;
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
                "ExpirationDate: " + dateToString(this.expirationDate) + ", " +
                "Owner: " + this.owner + ", " +
                "Cryptogram: " + this.cryptogram + " }";
    }

    private static String dateToString(Date date){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/yy");
        return simpleDateFormat.format(date);
    }

}
