package org.esgi.exposition;

public class CreditCardResponse {
    boolean isValid;

    public CreditCardResponse(boolean isValid) {
        this.isValid = isValid;
    }

    @Override
    public String toString() {
        return "CreditCardResponse{" +
                "isValid=" + isValid +
                '}';
    }
}
