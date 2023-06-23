package com.catan.democatanserver.catan.map.hex;


import com.catan.democatanserver.catan.map.Harbor;
import com.catan.democatanserver.catan.map.HexCorner;
import com.catan.democatanserver.catan.map.HexEdge;
import com.catan.democatanserver.catan.map.Resource;

import java.util.List;

public class WaterHex extends Hex {

    private Harbor harbor;

    public WaterHex(Harbor harbor, List<HexCorner> corners, List<HexEdge> edges) {
        super(Resource.Water, corners, edges);
        this.harbor = harbor;
    }

    public Harbor getHarbor() {
        return harbor;
    }
}
