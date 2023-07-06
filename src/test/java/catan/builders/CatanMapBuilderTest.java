package catan.builders;

import catan.builders.BaseMapBuilder;
import catan.map.CatanMap;
import catan.map.Harbor;
import catan.map.Resource;
import catan.map.hex.NumberedHex;
import catan.map.hex.WaterHex;
import catan.utils.HexUtils;
import catan.utils.MapUtils;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CatanMapBuilderTest {

    @Test
    public void validMapIsGenerated() {
        var size = 2;
        var map = new BaseMapBuilder(size)
                .setLandHexes()
                .setWaterHexes()
                .setResources(List.of(MapUtils.baseMapResources))
                .setNumbers(List.of(MapUtils.baseMapNumbers))
                .setHarbors(List.of(MapUtils.baseMapHarbors))
                .setCornersAndEdges()
                .getCatanMap();

        assertValidMap(map, size);
    }

    @Test
    public void randomMapBuilderIsGenerated() {
        var size = 2;
        var map = BaseMapBuilder.random(size).getCatanMap();
        assertValidMap(map, size);
    }

    void assertValidMap(CatanMap map, int size) {
        var numbers = new HashMap<Integer, Integer>();
        var resourceCount = new HashMap<Resource, Integer>();
        var harbourCount = new HashMap<Harbor, Integer>();

        for (var pos : HexUtils.hexesInRange(size + 1)) {
            var hex = map.getHex(pos);
            if (hex == null)
                fail("All hexes should be initialized");

            resourceCount.compute(hex.getResource(), (k, v) -> v == null ? 1 : v + 1);
            if (hex instanceof NumberedHex)
                numbers.compute(((NumberedHex) hex).getNumber(), (k, v) -> v == null ? 1 : v + 1);
            else if (hex instanceof WaterHex)
                harbourCount.compute(((WaterHex) hex).getHarbor(), (k, v) -> v == null ? 1 : v + 1);
        }

        assertEquals(3, resourceCount.get(Resource.Brick));
        assertEquals(4, resourceCount.get(Resource.Wood));
        assertEquals(4, resourceCount.get(Resource.Wheat));
        assertEquals(4, resourceCount.get(Resource.Sheep));
        assertEquals(3, resourceCount.get(Resource.Ore));
        assertEquals(1, resourceCount.get(Resource.Desert));
        assertEquals((size + 1) * 6, resourceCount.get(Resource.Water));

        assertEquals(1, numbers.get(2));
        assertEquals(1, numbers.get(12));
        for (int i = 3; i <= 11; i++)
            if (i != 7)
                assertEquals(2, numbers.get(i));

        assertEquals(4, harbourCount.get(Harbor.threeToOne()));
        assertEquals(1, harbourCount.get(Harbor.twoToOne(Resource.Brick)));
        assertEquals(1, harbourCount.get(Harbor.twoToOne(Resource.Wood)));
        assertEquals(1, harbourCount.get(Harbor.twoToOne(Resource.Wheat)));
        assertEquals(1, harbourCount.get(Harbor.twoToOne(Resource.Sheep)));
        assertEquals(1, harbourCount.get(Harbor.twoToOne(Resource.Ore)));
    }
}
