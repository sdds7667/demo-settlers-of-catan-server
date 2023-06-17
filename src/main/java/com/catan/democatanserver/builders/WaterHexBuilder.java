package com.catan.democatanserver.builders;

import com.catan.democatanserver.catan.map.Harbor;
import com.catan.democatanserver.catan.map.hex.Hex;
import com.catan.democatanserver.catan.map.Resource;
import com.catan.democatanserver.catan.map.hex.WaterHex;

public class WaterHexBuilder implements HexBuilder {

    private Harbor harbor;

    public WaterHexBuilder() {
        reset();
    }

    @Override
    public void reset() {
        harbor = null;
    }

    public void setHarbor(Harbor harbor) {
        if (harbor == null) throw new IllegalArgumentException("Harbor cannot be null");
        this.harbor = harbor;
    }

    @Override
    public Hex getHex() {
        if (harbor == null) throw new IllegalStateException("Harbor cannot be null");
        return new WaterHex(harbor);
    }
}
