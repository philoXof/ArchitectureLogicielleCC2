package org.esgi.domain.creditcard;

import java.util.Date;

public interface CreditCard {
    String cardNumber();

    Date expirationDate();

    String owner();

    String cryptogram();
}
