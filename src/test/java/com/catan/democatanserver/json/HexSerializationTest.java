package com.catan.democatanserver.json;

import com.catan.democatanserver.catan.map.Resource;
import com.catan.democatanserver.catan.map.hex.NumberedHex;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HexSerializationTest {
    @Test
    public void testLandHexSerialization() {

        String expected = "{\"resource\":\"Brick\",\"number\":5}";
        var hex = new NumberedHex(Resource.Brick, 5 );
        var objectMapper = new ObjectMapper();

        var json = "";
        try {
            json = objectMapper.writeValueAsString(hex);
        } catch (Exception e) {
            assert (false);
        }

        assertEquals(expected, json, "Hex should serialize to resource, number, q, and r");
    }
}
