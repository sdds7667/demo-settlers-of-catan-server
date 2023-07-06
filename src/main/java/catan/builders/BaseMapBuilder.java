package catan.builders;

import catan.map.*;
import catan.map.hex.Hex;
import catan.utils.HexUtils;
import catan.utils.MapUtils;
import catan.utils.ShuffledAccessor;

import java.util.HashMap;

public class BaseMapBuilder implements CatanMapBuilder {

    HashMap<Position, HexBuilder> hexes;

    public int size;

    public BaseMapBuilder(int size) {
        this.size = size;
        reset();
    }

    @Override
    public void reset() {
        if (hexes == null)
            hexes = new HashMap<>();
        else
            hexes.clear();
    }

    /**
     * Creates all the required hexes without resources, harbors or numbers.
     * Is automatically called by the reset function and the constructor.
     *
     * @return this, for chaining
     */
    @Override
    public BaseMapBuilder setLandHexes() {

        for (var hex : HexUtils.hexesInRange(size))
            hexes.put(hex, new LandHexBuilder());
        return this;
    }

    public BaseMapBuilder setWaterHexes() {
        for (var harbor : HexUtils.ringForRadius(size + 1))
            hexes.put(harbor, new WaterHexBuilder());
        return this;
    }

    public BaseMapBuilder setRandomHarbors() {
        return setHarbors(ShuffledAccessor.of(MapUtils.baseMapHarbors));
    }

    public BaseMapBuilder setResources(Iterable<Resource> resources) {
        var resourcesIterator = resources.iterator();
        for (var hexPosition : HexUtils.hexesInRange(size))
            ((LandHexBuilder) hexes.get(hexPosition)).setResource(resourcesIterator.next());
        return this;
    }

    public BaseMapBuilder setRandomResources() {
        return setResources(ShuffledAccessor.of(MapUtils.baseMapResources));
    }

    public BaseMapBuilder setNumbers(Iterable<Integer> integers) {
        var numbers = integers.iterator();
        for (var hexPosition : HexUtils.hexesInRange(size)) {
            var hex = (LandHexBuilder) hexes.get(hexPosition);
            if (hex.getResource() == Resource.Desert)
                continue;
            hex.setNumber(numbers.next());
        }
        return this;
    }

    @Override
    public BaseMapBuilder setHarbors(Iterable<Harbor> harbors) {
        var skip = true;
        var harborsIterator = harbors.iterator();
        for (var hexPosition : HexUtils.ringForRadius(size + 1)) {
            skip = !skip;
            if (skip)
                continue;
            ((WaterHexBuilder) hexes.get(hexPosition)).setHarbor(harborsIterator.next());
        }
        return this;
    }

    public BaseMapBuilder setRandomNumbers() {
        return setNumbers(ShuffledAccessor.of(MapUtils.baseMapNumbers));
    }


    public BaseMapBuilder setCornersAndEdges() {
        for (var hexPosition : HexUtils.hexesInRange(size)) {
            var hex = (LandHexBuilder) hexes.get(hexPosition);
            for (var i = 0; i < 6; i++) {
                if (hex.isCornerSet(i))
                    continue;
                var corner = new HexCorner();
                hex.setCorner(i, corner);
                var diff = 2;
                for (var neighbor : hexPosition.cornerNeighbors(i)) {
                    var neighborHex = (HexBuilder) hexes.get(neighbor);
                    if (neighborHex == null)
                        continue;
                    neighborHex.setCorner((i + diff) % 6, corner);
                    diff += 2;
                }


            }
            for (var i = 0; i < 6; i++) {
                if (hex.isEdgeSet(i))
                    continue;
                var edge = new HexEdge();
                hex.setEdge(i, edge);
                var neighborHex = (HexBuilder) hexes.get(hexPosition.neighbor(i));
                if (neighborHex == null)
                    continue;
                neighborHex.setEdge((i + 3) % 6, edge);
            }
        }
        return this;
    }

    public static BaseMapBuilder random(int size) {
        return new BaseMapBuilder(size)
                .setLandHexes()
                .setWaterHexes()
                .setRandomResources()
                .setRandomNumbers()
                .setRandomHarbors()
                .setCornersAndEdges();
    }

    @Override
    public CatanMap getCatanMap() {
        HashMap<Position, Hex> finalHexes = new HashMap<>();
        for (var entry : hexes.entrySet())
            finalHexes.put(entry.getKey(), entry.getValue().getHex());
        return new CatanMap(finalHexes);
    }
}
