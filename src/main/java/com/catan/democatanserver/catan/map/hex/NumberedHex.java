package com.catan.democatanserver.catan.map.hex;

import com.catan.democatanserver.catan.map.HexCorner;
import com.catan.democatanserver.catan.map.HexEdge;
import com.catan.democatanserver.catan.map.Resource;

import java.util.List;

public class NumberedHex extends Hex {

    private int number;

    public NumberedHex(Resource resource, int number, List<HexCorner> corners, List<HexEdge> edges) {
        super(resource, corners, edges);
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
