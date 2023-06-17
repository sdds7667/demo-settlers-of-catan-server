package com.catan.democatanserver.serializer;

import com.catan.democatanserver.catan.map.hex.Hex;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

public class HexSerializer extends StdSerializer<Hex> {

    HexSerializer() {
        this(null);
    }

    HexSerializer(Class<Hex> t) {
        super(t);
    }

    @Override
    public void serialize(Hex value, JsonGenerator gen, SerializerProvider provider) {
        try {
            gen.writeStartObject();
            gen.writeStringField("resource", value.getResource().toString());
            gen.writeEndObject();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


}
