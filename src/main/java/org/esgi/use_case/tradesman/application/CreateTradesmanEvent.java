package org.esgi.use_case.tradesman.application;

import org.esgi.use_case.tradesman.domain.Tradesman;
import org.esgi.kernel.ApplicationEvent;

import java.util.Objects;

public final class CreateTradesmanEvent implements ApplicationEvent {
    private final Tradesman tradesman;

    public CreateTradesmanEvent(Tradesman tradesman) {
        this.tradesman = tradesman;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CreateTradesmanEvent that = (CreateTradesmanEvent) o;
        return Objects.equals(tradesman, that.tradesman);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tradesman);
    }

    public Tradesman getTradesman(){
        return tradesman;
    }
}
