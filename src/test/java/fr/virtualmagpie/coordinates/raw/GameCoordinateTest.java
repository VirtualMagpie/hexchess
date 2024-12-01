package fr.virtualmagpie.coordinates.raw;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class GameCoordinateTest {

    @Test
    void representation() {
        GameCoordinate a1 = new GameCoordinate(1, 1);
        GameCoordinate a8 = new GameCoordinate(1, 8);
        GameCoordinate h1 = new GameCoordinate(8, 1);
        GameCoordinate h8 = new GameCoordinate(8, 8);
        GameCoordinate d2 = new GameCoordinate(4, 2);
        GameCoordinate l11 = new GameCoordinate(11, 11);

        Assertions.assertEquals("a1", a1.toString());
        Assertions.assertEquals("a8", a8.toString());
        Assertions.assertEquals("h1", h1.toString());
        Assertions.assertEquals("h8", h8.toString());
        Assertions.assertEquals("d2", d2.toString());
        Assertions.assertEquals("l11", l11.toString());
    }
}