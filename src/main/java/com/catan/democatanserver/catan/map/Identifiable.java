package com.catan.democatanserver.catan.map;

import java.util.UUID;

public class Identifiable {
    private final UUID id;

    public Identifiable() {
        this.id = UUID.randomUUID();
    }

    public UUID getId() {
        return id;
    }
}
