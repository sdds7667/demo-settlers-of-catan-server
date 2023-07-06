package catan.map;

import catan.map.hex.Hex;
import catan.serializer.CatanMapSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.util.Map;

@JsonSerialize(using = CatanMapSerializer.class)
public class CatanMap extends Identifiable {

    private Map<Position, Hex> hexes;

    public CatanMap(Map<Position, Hex> hexes) {
        this.hexes = hexes;
    }

    public Hex getHex(Position position) {
        return hexes.get(position);
    }

}
