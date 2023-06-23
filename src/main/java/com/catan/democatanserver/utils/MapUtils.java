package com.catan.democatanserver.utils;

import com.catan.democatanserver.catan.map.Resource;

public class MapUtils {
    public static Resource[] baseMapResources = new Resource[]{
            Resource.Wheat,
            Resource.Wheat,
            Resource.Wheat,
            Resource.Wheat,
            Resource.Sheep,
            Resource.Sheep,
            Resource.Sheep,
            Resource.Sheep,
            Resource.Wood,
            Resource.Wood,
            Resource.Wood,
            Resource.Wood,
            Resource.Brick,
            Resource.Brick,
            Resource.Brick,
            Resource.Ore,
            Resource.Ore,
            Resource.Ore,
            Resource.Desert
    };

    public static Integer[] baseMapNumbers = new Integer[]{2, 3, 3, 4, 4, 5, 5, 6, 6, 8, 8, 9, 9, 10, 10,
            11, 11, 12};
}
