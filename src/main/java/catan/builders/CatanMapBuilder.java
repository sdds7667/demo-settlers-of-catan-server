package catan.builders;

import catan.map.CatanMap;
import catan.map.Harbor;
import catan.map.Resource;

public interface CatanMapBuilder {
    void reset();

    CatanMapBuilder setLandHexes();

    CatanMapBuilder setWaterHexes();

    CatanMapBuilder setResources(Iterable<Resource> resources);

    CatanMapBuilder setNumbers(Iterable<Integer> numbers);

    CatanMapBuilder setHarbors(Iterable<Harbor> harbors);

    CatanMap getCatanMap();
}
