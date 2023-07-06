package catan.utils;

import catan.utils.PositionUtils;
import catan.map.Position;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PositionUtilsTest {

    static Position[] neighbors = new Position[]{
            new Position(-1, +0),
            new Position(-2, 0),
            new Position(-3, +1),
            new Position(-3, +2),
            new Position(-2, +2),
            new Position(-1, +1)
    };

    @Test
    public void testCornerNeighbors() {


        var position = new Position(-2, +1);

        assertArrayEquals(new Position[]{neighbors[5], neighbors[0]}, PositionUtils.cornerNeighbors(position, 0));
        assertArrayEquals(new Position[]{neighbors[0], neighbors[1]}, PositionUtils.cornerNeighbors(position, 1));
        assertArrayEquals(new Position[]{neighbors[1], neighbors[2]}, PositionUtils.cornerNeighbors(position, 2));
        assertArrayEquals(new Position[]{neighbors[2], neighbors[3]}, PositionUtils.cornerNeighbors(position, 3));
        assertArrayEquals(new Position[]{neighbors[3], neighbors[4]}, PositionUtils.cornerNeighbors(position, 4));
        assertArrayEquals(new Position[]{neighbors[4], neighbors[5]}, PositionUtils.cornerNeighbors(position, 5));
    }


    @Test
    public void testEdgeNeighbors() {
        var position = new Position(-2, +1);

        assertEquals(neighbors[0], PositionUtils.neighbor(position, 0));
        assertEquals(neighbors[1], PositionUtils.neighbor(position, 1));
        assertEquals(neighbors[2], PositionUtils.neighbor(position, 2));
        assertEquals(neighbors[3], PositionUtils.neighbor(position, 3));
        assertEquals(neighbors[4], PositionUtils.neighbor(position, 4));
        assertEquals(neighbors[5], PositionUtils.neighbor(position, 5));
    }

}