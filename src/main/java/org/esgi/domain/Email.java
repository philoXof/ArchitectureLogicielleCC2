package org.esgi.domain;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Email {
    private final String value;

    public Email(String value) {
        System.out.println(value);
        Objects.requireNonNull(value);
        if(!isValid(value)){
            throw new IllegalArgumentException("Invalid email !");
        }
        this.value = value;
    }

    /*
    source : https://www.baeldung.com/java-email-validation-regex
        - It allows numeric values from 0 to 9
        - Both uppercase and lowercase letters from a to z are allowed
        - Allowed are underscore “_”, hyphen “-” and dot “.”
        - Dot isn't allowed at the start and end of the local-part
        - Consecutive dots aren't allowed
        - For the local part, a maximum of 64 characters are allowed
     Restrictions for the domain-part in this regular expression include:
        - It allows numeric values from 0 to 9
        - We allow both uppercase and lowercase letters from a to z
        - Hyphen “-” and dot “.” isn't allowed at the start and end of the domain-part
        - No consecutive dots
     */
    private boolean isValid(String value) {
        Pattern p = Pattern.compile("^(?=.{1,64}@)[A-Za-z0-9\\+_-]+(\\.[A-Za-z0-9\\+_-]+)*@[^-][A-Za-z0-9\\+-]+(\\.[A-Za-z0-9\\+-]+)*(\\.[A-Za-z]{2,})$");
        Matcher m = p.matcher(value);
        return m.matches();
    }



    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Email email = (Email) o;
        return Objects.equals(value, email.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
