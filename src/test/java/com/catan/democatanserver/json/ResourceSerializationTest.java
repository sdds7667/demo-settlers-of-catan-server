package com.catan.democatanserver.json;

import com.catan.democatanserver.catan.Resource;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ResourceSerializationTest {
    @Test
    public void testSerialize() throws JsonProcessingException {

        ObjectMapper objectMapper = new ObjectMapper();
        Resource resource = Resource.Brick;
        String json = objectMapper.writeValueAsString(resource);
        assertEquals("\"Brick\"", json, "Resource should serialize to its name");
    }
}
