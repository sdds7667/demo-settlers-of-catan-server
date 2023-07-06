package catan.builders;

import catan.map.Harbor;
import catan.map.hex.Hex;
import catan.map.hex.WaterHex;

public class WaterHexBuilder extends BaseHexBuilder {


    private Harbor harbor;

    public WaterHexBuilder() {
        reset();
    }

    @Override
    public void reset() {
        super.reset();
        harbor = null;
    }


    public WaterHexBuilder setHarbor(Harbor harbor) {
        this.harbor = harbor;
        return this;
    }

    @Override
    public Hex getHex() {
        return new WaterHex(id, harbor, corners, edges);
    }
}
