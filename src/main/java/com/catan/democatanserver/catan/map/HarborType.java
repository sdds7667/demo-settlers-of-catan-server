package com.catan.democatanserver.catan.map;

public enum HarborType {
    TWO_TO_ONE(2),
    THREE_TO_ONE(3);

    public final int rate;

    HarborType(int rate) {
        this.rate = rate;
    }

}
