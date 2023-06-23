package com.catan.democatanserver.catan.map.hex;


import com.catan.democatanserver.catan.map.Harbor;
import com.catan.democatanserver.catan.map.HexCorner;
import com.catan.democatanserver.catan.map.HexEdge;
import com.catan.democatanserver.catan.map.Resource;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class WaterHex extends Hex {

    private Harbor harbor;

    public WaterHex(UUID id, Harbor harbor, List<HexCorner> corners, List<HexEdge> edges) {
        super(id, Resource.Water, corners, edges);
        this.harbor = harbor;
    }

    public WaterHex(Harbor harbor, List<HexCorner> corners, List<HexEdge> edges) {
        super(Resource.Water, corners, edges);
        this.harbor = harbor;
    }

    public Harbor getHarbor() {
        return harbor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof WaterHex waterHex)) return false;
        if (!super.equals(o)) return false;
        return Objects.equals(harbor, waterHex.harbor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), harbor);
    }
}
