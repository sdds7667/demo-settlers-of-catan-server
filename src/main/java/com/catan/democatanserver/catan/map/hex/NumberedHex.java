package com.catan.democatanserver.catan.map.hex;

import com.catan.democatanserver.catan.map.Resource;

public class NumberedHex extends Hex {

    private int number;

    public NumberedHex(Resource resource, int number) {
        super(resource);
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
