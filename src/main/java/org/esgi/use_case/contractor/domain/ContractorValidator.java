package org.esgi.use_case.contractor.domain;

import org.esgi.domain.creditcard.CreditCard;

public final class ContractorValidator {
    public boolean isValid(Contractor contractor) {
        if(isValidName(contractor.getFirstName()) &&
        isValidName(contractor.getLastName()) &&
                haveValidCreditCard(contractor.getCreditCard())
        )return true;
        System.out.println("invalid contractor " + contractor.getId());
        return false;
    }

    private static boolean isValidName(String value) {
        if (value != null && !value.equals("")) return true;
        System.out.println("You must set a firstName / lastName.");
        return false;
    }

    private static boolean haveValidCreditCard(CreditCard creditCard){
        if(creditCard != null) return true;
        //todo call api to verif CC
        System.out.println("Invalid credit card");
        return false;
    }
}
