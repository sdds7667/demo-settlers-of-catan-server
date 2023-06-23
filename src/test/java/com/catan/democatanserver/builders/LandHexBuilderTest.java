package com.catan.democatanserver.builders;

import com.catan.democatanserver.catan.map.HexCorner;
import com.catan.democatanserver.catan.map.HexEdge;
import com.catan.democatanserver.catan.map.Resource;
import com.catan.democatanserver.catan.map.hex.Hex;
import com.catan.democatanserver.catan.map.hex.NumberedHex;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestTemplate;
import org.junit.jupiter.params.ParameterizedTest;

import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class LandHexBuilderTest {


    @Test
    void testLandHexBuilder() {
        var number = 5;
        var resource = Resource.Brick;
        var corners = List.of(new HexCorner(), new HexCorner(), new HexCorner(), new HexCorner(), new HexCorner(), new HexCorner());
        var edges = List.of(new HexEdge(), new HexEdge(), new HexEdge(), new HexEdge(), new HexEdge(), new HexEdge());
        var id = UUID.randomUUID();
        var builder = new LandHexBuilder()
                .setNumber(5)
                .setResource(Resource.Brick)
                .setId(id);
        for (var i = 0; i < 6; i++) {
            builder.setCorner(i, corners.get(i));
            builder.setEdge(i, edges.get(i));
        }
        var hex = builder.getHex();

        var expected = new NumberedHex(id, resource, number, corners, edges);

        assertEquals(expected, hex);
    }


}