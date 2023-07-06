package catan.json;

import catan.map.Harbor;
import catan.map.HexCorner;
import catan.map.HexEdge;
import catan.map.Resource;
import catan.map.hex.Hex;
import catan.map.hex.NumberedHex;
import catan.map.hex.WaterHex;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class HexSerializationTest {

    @ParameterizedTest
    @MethodSource("landHexSource")
    public void testLandHexSerialization(Resource resource, int number, List<HexCorner> cornerList, List<HexEdge> edgeList,
                                         String cornerString, String edgeString) {
        Hex hex = new NumberedHex(UUID.randomUUID(), resource, number, cornerList, edgeList);
        String expected = "{" +
                "\"id\":\"" + hex.getId() + "\"," +
                "\"resource\":\"" + resource + "\"," +
                "\"corners\":" + cornerString + "," +
                "\"edges\":" + edgeString + "," +
                "\"number\":" + number +
                "}";


        ObjectMapper mapper = new ObjectMapper();
        String actual = null;

        try {
            actual = mapper.writeValueAsString(hex);
        } catch (Exception e) {
            fail("Exception thrown during serialization");
        }

        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @MethodSource("harborSource")
    public void testWaterHexSerialization(Harbor harbor, String expectedString) {
        Hex hex = new WaterHex(UUID.randomUUID(), harbor, null, null);
        String expected = "{\"id\":\"" + hex.getId() + "\",\"resource\":\"Water\",\"corners\":[],\"edges\":[]," + expectedString + "}";
        ObjectMapper mapper = new ObjectMapper();
        String actual = null;

        try {
            actual = mapper.writeValueAsString(hex);
        } catch (Exception e) {
            fail("Exception thrown during serialization");
        }

        assertEquals(expected, actual);
    }

    @Test
    public void testDesertHexSerializer() {
        Hex hex = new Hex(UUID.randomUUID(), Resource.Desert, null, null);
        String expected = "{\"id\":\"" + hex.getId() + "\",\"resource\":\"Desert\",\"corners\":[],\"edges\":[]}";
        ObjectMapper mapper = new ObjectMapper();
        String actual = null;

        try {
            actual = mapper.writeValueAsString(hex);
        } catch (Exception e) {
            fail("Exception thrown during serialization");
        }

        assertEquals(expected, actual);
    }

    public static Stream<Arguments> harborSource() {
        return Stream.of(
                Arguments.of(Harbor.threeToOne(), "\"harborRate\":3"),
                Arguments.of(Harbor.twoToOne(Resource.Brick), "\"harborRate\":2,\"harborResource\":\"Brick\"")
        );
    }


    public static Stream<Arguments> landHexSource() {

        var cornerList = List.of(
                new HexCorner(),
                new HexCorner(),
                new HexCorner()
        );

        var edgeList = List.of(
                new HexEdge(),
                new HexEdge(),
                new HexEdge()
        );

        var expectedCornerString = "[" + cornerList.stream().map(hex -> "\"" + hex.getId() + "\"").reduce((acc, x) -> acc + "," + x).orElse("") + "]";
        var expectedEdgeString = "[" + edgeList.stream().map(hex -> "\"" + hex.getId() + "\"").reduce((acc, x) -> acc + "," + x).orElse("") + "]";

        return Stream.of(
                Arguments.of(Resource.Brick, 5, null, null, "[]", "[]"),
                Arguments.of(Resource.Wheat, 4, null, null, "[]", "[]"),
                Arguments.of(Resource.Sheep, 12, null, null, "[]", "[]"),
                Arguments.of(Resource.Ore, 6, cornerList, edgeList, expectedCornerString, expectedEdgeString),
                Arguments.of(Resource.Wood, 8, cornerList, edgeList, expectedCornerString, expectedEdgeString)
        );
    }



    @Test
    public void testWithNullEdges() {
        var edgeList = new ArrayList<HexEdge>();
        edgeList.add(null);
        edgeList.add(null);
        Hex hex = new NumberedHex(UUID.randomUUID(), Resource.Brick, 5, null, edgeList);
        String expected = "{\"id\":\"" + hex.getId() + "\",\"resource\":\"Brick\",\"corners\":[],\"edges\":[],\"number\":5}";
        ObjectMapper mapper = new ObjectMapper();
        String actual = null;

        try {
            actual = mapper.writeValueAsString(hex);
        } catch (Exception e) {
            fail("Exception thrown during serialization");
        }

        assertEquals(expected, actual);
    }

}
