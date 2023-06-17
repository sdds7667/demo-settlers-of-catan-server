package com.catan.democatanserver.builders;

import com.catan.democatanserver.catan.map.CatanMap;
import com.catan.democatanserver.catan.map.Position;

import java.util.HashMap;

public class BaseMapBuilder implements CatanMapBuilder {


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



    }

    @Override
    public void setHarbors() {

    }

    @Override
    public void setResources() {

    }

    @Override
    public void setNumbers() {

    }

    @Override
    public CatanMap getCatanMap() {
        return null;
    }
}
