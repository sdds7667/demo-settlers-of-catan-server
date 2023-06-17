package com.catan.democatanserver.builders;

import com.catan.democatanserver.catan.map.hex.Hex;

public interface HexBuilder {

    void reset();

    Hex getHex();
}
