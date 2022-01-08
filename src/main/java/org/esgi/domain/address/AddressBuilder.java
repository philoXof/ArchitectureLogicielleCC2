package org.esgi.domain.address;

import java.util.Objects;

public final class AddressBuilder {

    private String number;
    private String line;
    private String city;
    private String country;

    private AddressBuilder(){}

    public static AddressBuilder create(){
        return new AddressBuilder();
    }

    public AddressBuilder withCity(String city) {
        AddressBuilder builder = new AddressBuilder();
        builder.city = Objects.requireNonNull(city);
        builder.country = country;
        builder.number = number;
        builder.line = line;
        return builder;
    }

    public AddressBuilder withCountry(String country) {
        AddressBuilder builder = new AddressBuilder();
        builder.city = city;
        builder.country = Objects.requireNonNull(country);
        builder.number = number;
        builder.line = line;
        return builder;
    }

    public AddressBuilder withNumber(String number) {
        AddressBuilder builder = new AddressBuilder();
        builder.city = city;
        builder.country = country;
        builder.number = Objects.requireNonNull(number);
        builder.line = line;
        return builder;
    }

    public AddressBuilder withLine(String line) {
        AddressBuilder builder = new AddressBuilder();
        builder.city = city;
        builder.country = country;
        builder.number = number;
        builder.line = Objects.requireNonNull(line);
        return builder;
    }

    public Address build(){
        return new DefaultAddress(number,line,city,country);
    }
}
