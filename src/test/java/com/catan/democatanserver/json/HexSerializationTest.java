package com.catan.democatanserver.json;

import com.catan.democatanserver.catan.map.Resource;
import com.catan.democatanserver.catan.map.hex.NumberedHex;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class HexSerializationTest {
    @Test
    public void testLandHexSerialization() {

        String expected = "{\"resource\":\"Brick\",\"number\":5,corners:[";
        var hex = new NumberedHex(Resource.Brick, 5, null, null );
        var objectMapper = new ObjectMapper();

        var json = "";
        try {
            json = objectMapper.writeValueAsString(hex);
        } catch (Exception e) {
            assert (false);
        }

        assertTrue(json.startsWith(expected));
    }
}
