package org.esgi.use_case.tradesman.domain;

import java.util.Objects;

public final class TradesmanId {
    private final int id;

    private TradesmanId(int id) {
        this.id = id;
    }

    public static TradesmanId of(int id) {
        return new TradesmanId(id);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TradesmanId playerId = (TradesmanId) o;
        return Objects.equals(id, playerId.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public String getValue() {
        return String.valueOf(id);
    }
}
