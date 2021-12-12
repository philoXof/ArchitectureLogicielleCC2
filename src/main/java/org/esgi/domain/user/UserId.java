package org.esgi.domain.user;

import java.util.Objects;

public class UserId {
    private final int id;

    private UserId(int id) {
        this.id = id;
    }

    public static UserId of(int id) {
        return new UserId(id);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserId playerId = (UserId) o;
        return Objects.equals(id, playerId.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
