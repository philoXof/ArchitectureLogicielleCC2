package org.esgi.domain.address;

public interface Address {
    String number();

    String line();

    String city();

    String country();

    Address changeAddress(Address address);
}
