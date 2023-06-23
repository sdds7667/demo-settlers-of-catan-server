package com.catan.democatanserver.utils;

import com.catan.democatanserver.catan.map.Position;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;

class HexUtilsTest {

    static HashSet<Position> expectations0;
    static HashSet<Position> expectations1;
    static HashSet<Position> expectations2;

    static HashSet<Position> ring0;
    static HashSet<Position> ring1;
    static HashSet<Position> ring2;

    @BeforeAll
    public static void setUp() {
        expectations0 = new HashSet<>();
        expectations0.add(new Position(0, 0));
        expectations1 = new HashSet<>();
        expectations1.addAll(expectations0);
        expectations1.add(new Position(1, -1));
        expectations1.add(new Position(0, -1));
        expectations1.add(new Position(-1, 0));
        expectations1.add(new Position(-1, 1));
        expectations1.add(new Position(0, 1));
        expectations1.add(new Position(1, 0));
        expectations2 = new HashSet<>();
        expectations2.addAll(expectations1);
        expectations2.add(new Position(2, -2));
        expectations2.add(new Position(1, -2));
        expectations2.add(new Position(0, -2));
        expectations2.add(new Position(-1, -1));
        expectations2.add(new Position(-2, 0));
        expectations2.add(new Position(-2, 1));
        expectations2.add(new Position(-2, 2));
        expectations2.add(new Position(-1, 2));
        expectations2.add(new Position(0, 2));
        expectations2.add(new Position(1, 1));
        expectations2.add(new Position(2, 0));
        expectations2.add(new Position(2, -1));

        ring1 = new HashSet<>(expectations1);
        ring1.removeAll(expectations0);
        ring2 = new HashSet<>(expectations2);
        ring2.removeAll(expectations1);

    }

    @Test
    public void testRangeSize0() {
        var actual = new HashSet<>();
        HexUtils.hexesInRange(0).forEach(actual::add);
        assertEquals(expectations0, actual);
    }

    @Test
    public void testRangeSize1() {
        var actual = new HashSet<>();
        HexUtils.hexesInRange(1).forEach(actual::add);
        assertEquals(expectations1, actual);
    }

    @Test
    public void testRangeSize2() {
        var actual = new HashSet<>();
        HexUtils.hexesInRange(2).forEach(actual::add);
        assertEquals(expectations2, actual);
    }

    @Test
    public void testRingSize0() {
        var actual = new HashSet<>();
        HexUtils.ringForRadius(0).forEach(actual::add);
        assertEquals(expectations0, actual);
    }

    @Test
    public void testRingSize1() {
        var actual = new HashSet<>();
        HexUtils.ringForRadius(1).forEach(actual::add);
        assertEquals(ring1, actual);
    }

    @Test
    public void testRingSize2() {
        var actual = new HashSet<>();
        HexUtils.ringForRadius(2).forEach(actual::add);
        var diff = new HashSet<>(actual);
        diff.removeAll(ring2);
        assertEquals(0, diff.size());
        assertEquals(ring2, actual);
    }

    @Test
    public void testRingSize3() {
        var actual = new HashSet<Position>();
        HexUtils.ringForRadius(3).forEach(actual::add);
        assertEquals(18, actual.size());
        for (var hex : actual) assertEquals(3, hex.distanceToOrigin());
    }

}