package com.catan.democatanserver.builders;

import com.catan.democatanserver.catan.map.hex.Hex;
import com.catan.democatanserver.catan.map.Resource;
import com.catan.democatanserver.catan.map.hex.NumberedHex;

public class LandHexBuilder implements HexBuilder {

    private Resource resource;
    private int number;

    public LandHexBuilder() {
        reset();
    }

    @Override
    public void reset() {
        resource = null;
        number = -1;
    }

    public Resource getResource() {
        return resource;
    }

    public void setResource(Resource resource) {
        if (resource == null) throw new IllegalArgumentException("Resource cannot be null");
        if (resource == Resource.Desert && number != -1)
            throw new IllegalArgumentException("Cannot set desert hex to have a number");
        if (resource == Resource.Water) throw new IllegalArgumentException("Cannot set a land hex to be water");
        this.resource = resource;
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
    public Hex getHex() {
        if (resource == null) throw new IllegalStateException("Resource must be set");
        if (number == -1) throw new IllegalStateException("Number must be set");
        if (resource == Resource.Desert) {
            return new Hex(resource);
        }
        return new NumberedHex(resource, number);
    }
}
