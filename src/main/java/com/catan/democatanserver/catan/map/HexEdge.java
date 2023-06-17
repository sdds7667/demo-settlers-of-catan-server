package com.catan.democatanserver.catan.map;

import java.util.UUID;

public class HexEdge extends Identifiable {

    private final UUID id;

    public HexEdge() {
        this.id = UUID.randomUUID();
    }

    public UUID getId() {
        return id;
    }

}
