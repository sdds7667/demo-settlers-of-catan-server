package com.catan.democatanserver.builders;

import com.catan.democatanserver.catan.map.Resource;
import com.catan.democatanserver.catan.map.hex.Hex;
import com.catan.democatanserver.catan.map.hex.NumberedHex;

public class LandHexBuilder extends BaseHexBuilder {


    private int number;


    @Override
    public void reset() {
        super.reset();
        number = -1;
    }


    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        if (number < 2 || number > 12) throw new IllegalArgumentException("Number must be between 2 and 12");
        if (resource == Resource.Desert) throw new IllegalArgumentException("Cannot set number on desert hex");
        this.number = number;
    }

    @Override
    public void setResource(Resource resource) {
        if (resource == Resource.Desert && number != -1)
            throw new IllegalArgumentException("Cannot set desert hex to have a number");
        if (resource == Resource.Water)
            throw new IllegalArgumentException("Cannot set land hex to have water resource");
        super.setResource(resource);
    }

    @Override
    public Hex getHex() {
        if (resource == null) throw new IllegalStateException("Resource must be set");
        if (number == -1) throw new IllegalStateException("Number must be set");
        if (resource == Resource.Desert) {
            return new Hex(resource, corners, edges);
        }
        return new NumberedHex(resource, number, corners, edges);
    }
}
