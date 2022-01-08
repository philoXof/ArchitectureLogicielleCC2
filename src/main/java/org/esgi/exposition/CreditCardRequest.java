package org.esgi.exposition;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

public class CreditCardRequest {

    @NotNull
    @NotBlank
    public String cardNumber;

    @NotNull
    @NotBlank
    public Date expirationDate;

    @NotNull
    @NotBlank
    public String owner;

    @NotNull
    @NotBlank
    public String cryptogram;
}
