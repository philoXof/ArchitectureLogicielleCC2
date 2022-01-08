package org.esgi.exposition;

import org.esgi.kernel.CommandBus;
import org.esgi.kernel.QueryBus;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RestController
public class CreditCardController {
    private final CommandBus commandBus;
    private final QueryBus queryBus;

    public CreditCardController(CommandBus commandBus, QueryBus queryBus) {
        this.commandBus = commandBus;
        this.queryBus = queryBus;
    }

    @GetMapping(path = "/creditCard",
            produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE},
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CreditCardResponse> IsValid(@RequestBody @Valid CreditCardRequest request)  {
        if (this.IsValidCardNumber(request.cardNumber) &&
                this.IsValidCreditCardOwner(request.owner) &&
                this.IsValidCryptogram(request.cryptogram) &&
                this.IsValidExpirationDate(request.expirationDate)) {
                    return ResponseEntity.ok(new CreditCardResponse(true));
        }
        return ResponseEntity.ok(new CreditCardResponse(false));
    }

    public boolean IsValidExpirationDate(Date expirationDate) {
        return !expirationDate.before(new Date());
    }

    public boolean IsValidCryptogram(String cryptogram) {
        return IsValidFromRegex("^\\d{1,3}$",cryptogram);
    }

    public boolean IsValidCardNumber(String cardNumber) {
        String creditCardRegex = "^(?:4[0-9]{12}(?:[0-9]" +
                "{3})?|[25][1-7][0-9]{14}|6(?:011|5[0-9]" +
                "[0-9])[0-9]{12}|3[47][0-9]{13}|3(?:0[0-5]" +
                "|[68][0-9])[0-9]{11}|(?:2131|1800|35\\d{3})\\d{11})$";
        return IsValidFromRegex(creditCardRegex, cardNumber);
    }

    public boolean IsValidCreditCardOwner(String cardOwner) {
        return !Objects.equals(cardOwner, "");
    }

    private boolean IsValidFromRegex(String patternRegex, String input){
        Pattern p = Pattern.compile(patternRegex);
        Matcher m = p.matcher(input);
        return m.matches();
    }



    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach(error -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }
}
