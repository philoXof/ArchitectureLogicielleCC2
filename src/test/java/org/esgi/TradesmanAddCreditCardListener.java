package org.esgi;

import org.esgi.application.TradesmanAddCreditCard;
import org.esgi.kernel.EventListener;

public class TradesmanAddCreditCardListener implements EventListener<TradesmanAddCreditCard> {
    @Override
    public void listenTo(TradesmanAddCreditCard event) {
        System.out.println(event.getCardNumber());
        System.out.println(event.getOwner());
        System.out.println(event.getExpirationDate());
        System.out.println(event.getCryptogram());
    }
}
