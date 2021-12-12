package org.esgi.domain.address;

public class DefaultAddress implements Address{
    private final String number;
    private final String line;
    private final String city;
    private final String country;

    public DefaultAddress(String number, String line,
                          String city, String country) {
        this.number = number;
        this.line = line;
        this.city = city;
        this.country = country;
    }

    @Override
    public String number() {
        return this.number;
    }

    @Override
    public String line() {
        return this.line;
    }

    @Override
    public String city() {
        return this.city;
    }

    @Override
    public String country() {
        return this.country;
    }

    @Override
    public String toString(){
        return "Address:{ " +
                "number: " + this.number + ", " +
                "line: " + this.line + ", " +
                "city: " + this.city + ", " +
                "country: " + this.country + " }";
    }
}
