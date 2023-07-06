package catan.serializer;

import catan.map.CatanMap;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;

public class CatanMapSerializer extends StdSerializer<CatanMap> {

    CatanMapSerializer() {
        this(null);
    }

    CatanMapSerializer(Class<CatanMap> t) {
        super(t);
    }

    @Override
    public void serialize(CatanMap value, JsonGenerator gen, SerializerProvider provider) throws IOException {
        gen.writeStartObject();

        gen.writeEndArray();
    }
}
