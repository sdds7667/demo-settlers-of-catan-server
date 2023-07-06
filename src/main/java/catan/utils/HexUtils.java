package catan.utils;

import catan.map.Position;

import java.util.Iterator;

public class HexUtils {


    public static Iterable<Position> hexesInRange(int size) {

        return () -> new Iterator<>() {
            int q = -size;
            int r = Math.max(-size, -q - size);

            @Override
            public boolean hasNext() {
                return q <= size && r <= Math.min(size, -q + size);
            }

            @Override
            public Position next() {
                var position = new Position(q, r);
                if (r == Math.min(size, -q + size)) {
                    q++;
                    r = Math.max(-size, -q - size);
                } else {
                    r++;
                }
                return position;
            }
        };

    }

    public static Iterable<Position> ringForRadius(int radius) {

        if (radius == 0) {
            return () -> new Iterator<>() {
                Position position = new Position(0, 0);

                @Override
                public boolean hasNext() {
                    return position != null;
                }

                @Override
                public Position next() {
                    var next = position;
                    position = null;
                    return next;
                }
            };
        }

        return () -> new Iterator<>() {
            int i = 0;
            int j = 0;
            Position originalPosition = new Position(radius, -radius);

            @Override
            public boolean hasNext() {
                return i < 6;
            }

            @Override
            public Position next() {
                var position = originalPosition;
                originalPosition = originalPosition.neighbor(i + 2);
                if (j == radius - 1) {
                    i++;
                    j = 0;
                } else {
                    j++;
                }
                return position;
            }
        };
    }

}
