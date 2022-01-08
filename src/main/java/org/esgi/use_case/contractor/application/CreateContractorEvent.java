package org.esgi.use_case.contractor.application;

import org.esgi.kernel.ApplicationEvent;
import org.esgi.use_case.contractor.domain.Contractor;
import java.util.Objects;

public final class CreateContractorEvent implements ApplicationEvent {
    private final Contractor contractor;

    public CreateContractorEvent(Contractor contractor) {
        this.contractor = contractor;
    }

    public Contractor getContractor(){
        return contractor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CreateContractorEvent that = (CreateContractorEvent) o;
        return Objects.equals(contractor, that.contractor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(contractor);
    }
}
