package org.esgi.domain.creditcard;
import java.util.Date;
import java.util.Objects;

public final class CreditCardBuilder {
    private String cardNumber;
    private Date expirationDate;
    private String owner;
    private String cryptogram;

    public CreditCardBuilder() {}

    public static CreditCardBuilder create(){
        return new CreditCardBuilder();
    }

    public CreditCardBuilder withCardNumber(String cardNumber){
        CreditCardBuilder builder = new CreditCardBuilder();
        builder.cardNumber = Objects.requireNonNull(cardNumber);
        builder.expirationDate = expirationDate;
        builder.owner = owner;
        builder.cryptogram = cryptogram;
        return builder;
    }

    public CreditCardBuilder withExpirationDate(Date expirationDate){
        CreditCardBuilder builder = new CreditCardBuilder();
        builder.cardNumber = cardNumber;
        builder.expirationDate = Objects.requireNonNull(expirationDate);
        builder.owner = owner;
        builder.cryptogram = cryptogram;
        return builder;
    }

    public CreditCardBuilder withCreditCardOwner(String owner){
        CreditCardBuilder builder = new CreditCardBuilder();
        builder.cardNumber = cardNumber;
        builder.expirationDate = expirationDate;
        builder.owner = Objects.requireNonNull(owner);
        builder.cryptogram = cryptogram;
        return builder;
    }

    public CreditCardBuilder withCryptogram(String cryptogram){
        CreditCardBuilder builder = new CreditCardBuilder();
        builder.cardNumber = cardNumber;
        builder.expirationDate = expirationDate;
        builder.owner = owner;
        builder.cryptogram = Objects.requireNonNull(cryptogram);
        return builder;
    }

    public CreditCard build(){
        return new DefaultCreditCard(cardNumber, expirationDate, owner, cryptogram);
    }
}
