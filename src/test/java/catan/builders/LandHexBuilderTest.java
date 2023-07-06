package catan.builders;

import catan.builders.LandHexBuilder;
import catan.map.HexCorner;
import catan.map.HexEdge;
import catan.map.Resource;
import catan.map.hex.NumberedHex;
import org.junit.jupiter.api.Test;

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

        if (!(hex instanceof NumberedHex)) {
            fail("Hex is not a NumberedHex");
        }
        var numberedHex = (NumberedHex) hex;

        assertEquals(numberedHex.getId(), id);
        assertEquals(numberedHex.getNumber(), number);
        assertEquals(numberedHex.getResource(), resource);
        for (var i = 0; i < 6; i++) {
            assertEquals(numberedHex.getCorners().get(i).getId(), corners.get(i).getId());
            assertEquals(numberedHex.getEdges().get(i).getId(), edges.get(i).getId());
        }
    }

    @Test
    public void testDesertBuilder() {
        var id = UUID.randomUUID();
        var builder = new LandHexBuilder()
                .setResource(Resource.Desert)
                .setId(id);
        var hex = builder.getHex();

        if (hex instanceof NumberedHex) {
            fail("Hex is a NumberedHex");
        }

        assertEquals(hex.getId(), id);
        assertEquals(hex.getResource(), Resource.Desert);
        assertEquals(hex.getCorners().size(), 6);
        assertEquals(hex.getEdges().size(), 6);
    }

    @Test
    public void numberOnDesert() {
        assertThrows(IllegalArgumentException.class, () -> new LandHexBuilder().setResource(Resource.Desert).setNumber(5));
        assertThrows(IllegalArgumentException.class, () -> new LandHexBuilder().setNumber(5).setResource(Resource.Desert));
    }

    @Test
    public void numberOutsideBounds() {
        assertThrows(IllegalArgumentException.class, () -> new LandHexBuilder().setNumber(1));
        assertThrows(IllegalArgumentException.class, () -> new LandHexBuilder().setNumber(0));
        assertThrows(IllegalArgumentException.class, () -> new LandHexBuilder().setNumber(13));
        assertThrows(IllegalArgumentException.class, () -> new LandHexBuilder().setNumber(14));
    }

    @Test
    public void waterCannotBeSet() {
        assertThrows(IllegalArgumentException.class, () -> new LandHexBuilder().setResource(Resource.Water));
    }

    @Test
    public void everythingNeedsToBeSet() {
        assertThrows(IllegalStateException.class, () -> new LandHexBuilder().getHex());
        assertThrows(IllegalStateException.class, () -> new LandHexBuilder().setResource(Resource.Brick).getHex());
        assertThrows(IllegalStateException.class, () -> new LandHexBuilder().setNumber(5).getHex());
    }

    @Test
    public void noIdGeneration() {
        var hex = new LandHexBuilder().setResource(Resource.Desert).getHex();
        if (hex instanceof NumberedHex)
            fail("Hex is a NumberedHex");
        assertNotNull(hex.getId());
        assertEquals(hex.getResource(), Resource.Desert);

    }

}