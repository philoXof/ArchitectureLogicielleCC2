package org.esgi.domain.contractor;

import java.util.Objects;

public class ContractorId {
    private final int id;

    public ContractorId(int id) {
        this.id = id;
    }

    public static ContractorId of(int id){
        return new ContractorId(id);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContractorId that = (ContractorId) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public int getValue() {
        return id;
    }
}
