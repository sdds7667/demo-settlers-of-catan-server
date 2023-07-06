package catan.utils;

import catan.map.Harbor;
import catan.map.Resource;

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

    public static Harbor[] baseMapHarbors = new Harbor[]{
            Harbor.threeToOne(), Harbor.threeToOne(), Harbor.threeToOne(), Harbor.threeToOne(),
            Harbor.twoToOne(Resource.Wheat), Harbor.twoToOne(Resource.Sheep), Harbor.twoToOne(Resource.Wood),
            Harbor.twoToOne(Resource.Brick), Harbor.twoToOne(Resource.Ore)
    };
}
