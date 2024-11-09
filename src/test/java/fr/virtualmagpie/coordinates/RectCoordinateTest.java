package fr.virtualmagpie.coordinates;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class RectCoordinateTest {

    @Test
    void representation() {
        RectCoordinate a1 = new RectCoordinate(1, 1);
        RectCoordinate a8 = new RectCoordinate(1, 8);
        RectCoordinate h1 = new RectCoordinate(8, 1);
        RectCoordinate h8 = new RectCoordinate(8, 8);
        RectCoordinate d2 = new RectCoordinate(4, 2);

        Assertions.assertEquals("a1", a1.toString());
        Assertions.assertEquals("a8", a8.toString());
        Assertions.assertEquals("h1", h1.toString());
        Assertions.assertEquals("h8", h8.toString());
        Assertions.assertEquals("d2", d2.toString());
    }

    @Test
    void toDisplayCoordinate() {
        RectCoordinate a1 = new RectCoordinate(1, 1);
        RectCoordinate a8 = new RectCoordinate(1, 8);
        RectCoordinate h1 = new RectCoordinate(8, 1);
        RectCoordinate h8 = new RectCoordinate(8, 8);
        RectCoordinate d2 = new RectCoordinate(4, 2);

        int[] a1DisplayCoord = a1.toDisplayCoordinate(8);
        int[] a8DisplayCoord = a8.toDisplayCoordinate(8);
        int[] h1DisplayCoord = h1.toDisplayCoordinate(8);
        int[] h8DisplayCoord = h8.toDisplayCoordinate(8);
        int[] d2DisplayCoord = d2.toDisplayCoordinate(8);

        // a1
        Assertions.assertEquals(2, a1DisplayCoord.length);
        Assertions.assertEquals(0, a1DisplayCoord[0]);
        Assertions.assertEquals(7, a1DisplayCoord[1]);
        // a8
        Assertions.assertEquals(0, a8DisplayCoord[0]);
        Assertions.assertEquals(0, a8DisplayCoord[1]);
        // h1
        Assertions.assertEquals(7, h1DisplayCoord[0]);
        Assertions.assertEquals(7, h1DisplayCoord[1]);
        // h8
        Assertions.assertEquals(7, h8DisplayCoord[0]);
        Assertions.assertEquals(0, h8DisplayCoord[1]);
        // d2
        Assertions.assertEquals(3, d2DisplayCoord[0]);
        Assertions.assertEquals(6, d2DisplayCoord[1]);

        // in a 10x10 grid
        int[] d2DisplayCoord10 = d2.toDisplayCoordinate(10);
        Assertions.assertEquals(3, d2DisplayCoord10[0]);
        Assertions.assertEquals(8, d2DisplayCoord10[1]);
    }
}