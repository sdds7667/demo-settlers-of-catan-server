package com.catan.democatanserver.builders;

import com.catan.democatanserver.catan.map.*;
import com.catan.democatanserver.catan.map.hex.Hex;
import com.catan.democatanserver.utils.HexUtils;
import com.catan.democatanserver.utils.MapUtils;
import com.catan.democatanserver.utils.ShuffledAccessor;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class BaseMapBuilder implements CatanMapBuilder {

    HashMap<Position, HexBuilder> hexes;
    List<LandHexBuilder> landHexes;

    public int size;

    public BaseMapBuilder(int size) {
        this.size = size;
        reset();
    }

    @Override
    public void reset() {

    }

    @Override
    public void setLandHexes() {
        for (var hex : HexUtils.hexesInRange(size))
            hexes.put(hex, new LandHexBuilder());
    }

    @Override
    public void setHarbors() {
        for (var harbor : HexUtils.ringForRadius(size))
            hexes.put(harbor, new WaterHexBuilder());
    }

    @Override
    public void setResources() {
        var shuffledResources = ShuffledAccessor.of(MapUtils.baseMapResources).iterator();
        for (var hexPosition : HexUtils.hexesInRange(size)) {
            var hex = (LandHexBuilder) hexes.get(hexPosition);
            hex.setResource(shuffledResources.next());
        }
    }

    @Override
    public void setNumbers() {
        var shuffledNumbers = ShuffledAccessor.of(MapUtils.baseMapNumbers).iterator();
        for (var hexPosition : HexUtils.hexesInRange(size)) {
            var hex = (LandHexBuilder) hexes.get(hexPosition);
            if (hex.getResource() == Resource.Desert)
                continue;
            hex.setNumber(shuffledNumbers.next());
        }
    }


    public void setCornersAndEdges() {
        for (var hexPosition : HexUtils.hexesInRange(size)) {
            var hex = (LandHexBuilder) hexes.get(hexPosition);
            for (var i = 0; i < 6; i++) {
                if (hex.isCornerSet(i))
                    continue;
                var corner = new HexCorner();
                hex.setCorner(i, corner);
                var diff = 2;
                for (var neighbor : hexPosition.cornerNeighbors(i)) {
                    var neighborHex = (LandHexBuilder) hexes.get(neighbor);
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
                var neighborHex = (LandHexBuilder) hexes.get(hexPosition.neighbor(i));
                if (neighborHex == null)
                    continue;
                neighborHex.setEdge((i + 3) % 6, edge);
            }
        }
    }

    @Override
    public CatanMap getCatanMap() {
        HashMap<Position, Hex> finalHexes = new HashMap<>();
        for (var entry : hexes.entrySet())
            finalHexes.put(entry.getKey(), entry.getValue().getHex());
        return new CatanMap(finalHexes);
    }
}
