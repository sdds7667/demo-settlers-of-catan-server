package catan.builders;

import catan.map.HexCorner;
import catan.map.HexEdge;
import catan.map.hex.Hex;

public interface HexBuilder {

    void reset();

    HexBuilder setCorner(int index, HexCorner corner);

    HexBuilder setEdge(int index, HexEdge edge);

    Hex getHex();
}
