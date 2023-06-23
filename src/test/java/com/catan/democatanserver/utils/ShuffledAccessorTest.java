package com.catan.democatanserver.utils;

import com.catan.democatanserver.catan.map.Resource;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class ShuffledAccessorTest {

    @Test
    public void test() {
        var shuffledAccessor = new ShuffledAccessor<>(MapUtils.baseMapResources);
        var actual = new HashMap<Resource, Integer>();
        var newOrder = new ArrayList<Resource>();
        for (var resource : shuffledAccessor) {
            actual.put(resource, actual.getOrDefault(resource, 0) + 1);
            newOrder.add(resource);
        }
        assertEquals(1, actual.get(Resource.Desert));
        assertEquals(3, actual.get(Resource.Ore));
        assertEquals(3, actual.get(Resource.Brick));
        assertEquals(4, actual.get(Resource.Wood));
        assertEquals(4, actual.get(Resource.Sheep));
        assertEquals(4, actual.get(Resource.Wheat));
        var allEquals = true;
        for (int i = 0; i < MapUtils.baseMapResources.length; i++) {
            if (MapUtils.baseMapResources[i] != newOrder.get(i)) {
                allEquals = false;
                break;
            }
        }
        assertFalse(allEquals);
    }

}