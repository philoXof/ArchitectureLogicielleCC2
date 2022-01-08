package org.esgi.domain.address;

public final class DefaultAddress implements Address{
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
    public Address changeAddress(Address address) {
        return address;
    }

    @Override
    public String toString(){
        return "Address:{ " +
                "Number: " + this.number + ", " +
                "Line: " + this.line + ", " +
                "City: " + this.city + ", " +
                "Country: " + this.country + " }";
    }
}
