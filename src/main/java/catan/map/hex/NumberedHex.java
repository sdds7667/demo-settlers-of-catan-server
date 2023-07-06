package catan.map.hex;

import catan.map.HexCorner;
import catan.map.HexEdge;
import catan.map.Resource;

import java.util.List;
import java.util.Objects;
import java.util.UUID;


public class NumberedHex extends Hex {

    private int number;

    public NumberedHex(UUID id, Resource resource, int number, List<HexCorner> corners, List<HexEdge> edges) {
        super(id, resource, corners, edges);
        this.number = number;
    }

    public NumberedHex(Resource resource, int number, List<HexCorner> corners, List<HexEdge> edges) {
        super(resource, corners, edges);
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        NumberedHex that = (NumberedHex) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), number);
    }
}
