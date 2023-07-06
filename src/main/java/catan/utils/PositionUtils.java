package catan.utils;

import catan.map.Position;

public class PositionUtils {

    static Position[] directions = {new Position(+1, -1), new Position(0, -1), new Position(-1, 0), new Position(-1, +1), new Position(0, +1), new Position(+1, 0),};


    public static Position neighbor(Position position, int direction) {
        if (direction < 0)
            direction += 6;
        return new Position(position.q() + directions[direction % 6].q(), position.r() + directions[direction % 6].r());
    }

    public static int distanceToOrigin(Position position) {
        var s = -position.q() - position.r();
        return (Math.abs(position.q()) + Math.abs(position.r()) + Math.abs(s)) / 2;
    }

    public static Position[] cornerNeighbors(Position position, int direction) {
        return new Position[]{neighbor(position, direction - 1), neighbor(position, direction)};
    }



}
