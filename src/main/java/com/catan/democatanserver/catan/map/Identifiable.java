package com.catan.democatanserver.catan.map;

import java.util.Objects;
import java.util.UUID;

public class Identifiable {
    private final UUID id;

    public Identifiable() {
        this.id = UUID.randomUUID();
    }

    public Identifiable(UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return id;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Identifiable that = (Identifiable) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
