package catan.map;

import catan.utils.PositionUtils;

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
