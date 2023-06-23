package com.catan.democatanserver.builders;

import com.catan.democatanserver.catan.map.HexCorner;
import com.catan.democatanserver.catan.map.HexEdge;
import com.catan.democatanserver.catan.map.hex.Hex;

public interface HexBuilder {

    void reset();

    HexBuilder setCorner(int index, HexCorner corner);

    HexBuilder setEdge(int index, HexEdge edge);

    Hex getHex();
}
