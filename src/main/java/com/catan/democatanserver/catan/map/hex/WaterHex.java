package com.catan.democatanserver.catan.map.hex;


import com.catan.democatanserver.catan.map.Harbor;
import com.catan.democatanserver.catan.map.Resource;

public class WaterHex extends Hex {

    private Harbor harbor;

    public WaterHex(Harbor harbor) {
        super(Resource.Water);
        this.harbor = harbor;
    }

    public Harbor getHarbor() {
        return harbor;
    }
}
