package catan.serializer;

import catan.map.HarborType;
import catan.map.Identifiable;
import catan.map.hex.Hex;
import catan.map.hex.NumberedHex;
import catan.map.hex.WaterHex;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;
import java.util.List;

public class HexSerializer extends StdSerializer<Hex> {

    HexSerializer() {
        this(null);
    }

    HexSerializer(Class<Hex> t) {
        super(t);
    }

    @Override
    public void serialize(Hex value, JsonGenerator gen, SerializerProvider provider) throws IOException {
        gen.writeStartObject();
        writeHexFields(value, gen, provider);

        if (value instanceof NumberedHex)
            writeHexNumber((NumberedHex) value, gen, provider);
        else if (value instanceof WaterHex)
            writeHarbor((WaterHex) value, gen, provider);
        gen.writeEndObject();
    }

    public void writeHexFields(Hex value, JsonGenerator gen, SerializerProvider provider) throws IOException {
        gen.writeStringField("id", value.getId().toString());
        gen.writeStringField("resource", value.getResource().toString());

        writeIdentifiableList("corners", value.getCorners(), gen);
        writeIdentifiableList("edges", value.getEdges(), gen);
    }

    public void writeIdentifiableList(String fieldName, List<? extends Identifiable> ids, JsonGenerator gen) throws IOException {

        gen.writeArrayFieldStart(fieldName);
        if (ids != null)
            for (var identifiable : ids)
                if (identifiable != null)
                    gen.writeString(identifiable.getId().toString());
        gen.writeEndArray();
    }


    public void writeHexNumber(NumberedHex value, JsonGenerator gen, SerializerProvider provider) throws IOException {
        gen.writeNumberField("number", value.getNumber());
    }

    public void writeHarbor(WaterHex value, JsonGenerator gen, SerializerProvider provider) throws IOException {
        var harbor = value.getHarbor();
        gen.writeNumberField("harborRate", harbor.harborType().rate);
        if (harbor.harborType() == HarborType.TWO_TO_ONE)
            gen.writeStringField("harborResource", harbor.resource().toString());
    }


}
