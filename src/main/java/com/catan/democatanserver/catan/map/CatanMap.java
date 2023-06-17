package com.catan.democatanserver.catan.map;

import com.catan.democatanserver.catan.map.hex.Hex;
import com.catan.democatanserver.serializer.CatanMapSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.util.HashMap;
import java.util.Map;

@JsonSerialize(using = CatanMapSerializer.class)
public class CatanMap extends Identifiable {

    private Map<Position, Hex> hexes;

    public CatanMap() {
        hexes = new HashMap<>();
    }
}
