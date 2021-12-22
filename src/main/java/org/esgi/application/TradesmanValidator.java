package org.esgi.application;

import org.esgi.domain.address.Address;
import org.esgi.domain.tradesman.Tradesman;

import java.util.Objects;

public class TradesmanValidator {
    private final Tradesman tradesman;

    public TradesmanValidator(Tradesman tradesman) {
        this.tradesman = tradesman;
    }

    public Tradesman getTradesman() {
        return tradesman;
    }

    public boolean isValid(){
        if(!Objects.equals(this.tradesman.getFirstName(), "")) return false;
        if(!Objects.equals(this.tradesman.getLastName(),"")) return false;
        //skills
        return true;
    }

}
