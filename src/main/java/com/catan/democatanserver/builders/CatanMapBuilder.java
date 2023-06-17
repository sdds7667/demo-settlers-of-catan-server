package com.catan.democatanserver.builders;

import com.catan.democatanserver.catan.map.CatanMap;

public interface CatanMapBuilder {
    void reset();

    void setLandHexes();

    void setHarbors();

    void setResources();

    void setNumbers();

    CatanMap getCatanMap();
}
