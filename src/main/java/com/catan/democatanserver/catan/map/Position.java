package com.catan.democatanserver.catan.map;

import com.catan.democatanserver.utils.PositionUtils;

public record Position(int q, int r) {


    public Position neighbor(int direction) {
        return PositionUtils.neighbor(this, direction);
    }

    public int distanceToOrigin() {
        return PositionUtils.distanceToOrigin(this);
    }

    public Position[] cornerNeighbors(int direction) {
        return PositionUtils.cornerNeighbors(this, direction);
    }
}
