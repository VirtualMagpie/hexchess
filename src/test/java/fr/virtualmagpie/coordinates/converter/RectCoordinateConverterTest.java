package fr.virtualmagpie.coordinates.converter;

import fr.virtualmagpie.coordinates.raw.DisplayCoordinate;
import fr.virtualmagpie.coordinates.raw.GameCoordinate;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class RectCoordinateConverterTest {

    /*
     *              Display                                Game
     *
     *     0,0    1,0    2,0    3,0               a4     b4     c4     d4
     *
     *     0,1    1,1    2,1    3,1               a3     b3     c3     d3
     *
     *     0,2    1,2    2,2    3,2               a2     b2     c2     d2
     *
     *     0,3    1,3    2,3    3,3               a1     b1     c1     d1
     */
    @Nested
    class Grid4 {

        int boardSize = 4;

        DisplayCoordinate display00 = new DisplayCoordinate(0, 0);
        DisplayCoordinate display21 = new DisplayCoordinate(2, 1);
        DisplayCoordinate display22 = new DisplayCoordinate(2, 2);
        DisplayCoordinate display30 = new DisplayCoordinate(3, 0);
        DisplayCoordinate display03 = new DisplayCoordinate(0, 3);
        DisplayCoordinate display33 = new DisplayCoordinate(3, 3);

        GameCoordinate gameA4 = new GameCoordinate(1, 4);
        GameCoordinate gameC3 = new GameCoordinate(3, 3);
        GameCoordinate gameC2 = new GameCoordinate(3, 2);
        GameCoordinate gameD4 = new GameCoordinate(4, 4);
        GameCoordinate gameA1 = new GameCoordinate(1, 1);
        GameCoordinate gameD1 = new GameCoordinate(4, 1);

        @Test
        void toGameCoord() {
            Assertions.assertEquals(gameA4, RectCoordinateConverter.toGameCoord(display00, boardSize));
            Assertions.assertEquals(gameC3, RectCoordinateConverter.toGameCoord(display21, boardSize));
            Assertions.assertEquals(gameC2, RectCoordinateConverter.toGameCoord(display22, boardSize));
            Assertions.assertEquals(gameD4, RectCoordinateConverter.toGameCoord(display30, boardSize));
            Assertions.assertEquals(gameA1, RectCoordinateConverter.toGameCoord(display03, boardSize));
            Assertions.assertEquals(gameD1, RectCoordinateConverter.toGameCoord(display33, boardSize));
        }

        @Test
        void toDisplayCoord() {
            Assertions.assertEquals(display00, RectCoordinateConverter.toDisplayCoord(gameA4, boardSize));
            Assertions.assertEquals(display21, RectCoordinateConverter.toDisplayCoord(gameC3, boardSize));
            Assertions.assertEquals(display22, RectCoordinateConverter.toDisplayCoord(gameC2, boardSize));
            Assertions.assertEquals(display30, RectCoordinateConverter.toDisplayCoord(gameD4, boardSize));
            Assertions.assertEquals(display03, RectCoordinateConverter.toDisplayCoord(gameA1, boardSize));
            Assertions.assertEquals(display33, RectCoordinateConverter.toDisplayCoord(gameD1, boardSize));
        }

        @Test
        void loop() {
            Assertions.assertEquals(display00, RectCoordinateConverter.toDisplayCoord(RectCoordinateConverter.toGameCoord(display00, boardSize), boardSize));
            Assertions.assertEquals(display03, RectCoordinateConverter.toDisplayCoord(RectCoordinateConverter.toGameCoord(display03, boardSize), boardSize));
            Assertions.assertEquals(display30, RectCoordinateConverter.toDisplayCoord(RectCoordinateConverter.toGameCoord(display30, boardSize), boardSize));
            Assertions.assertEquals(display33, RectCoordinateConverter.toDisplayCoord(RectCoordinateConverter.toGameCoord(display33, boardSize), boardSize));

            Assertions.assertEquals(gameA1, RectCoordinateConverter.toGameCoord(RectCoordinateConverter.toDisplayCoord(gameA1, boardSize), boardSize));
            Assertions.assertEquals(gameA4, RectCoordinateConverter.toGameCoord(RectCoordinateConverter.toDisplayCoord(gameA4, boardSize), boardSize));
            Assertions.assertEquals(gameD1, RectCoordinateConverter.toGameCoord(RectCoordinateConverter.toDisplayCoord(gameD1, boardSize), boardSize));
            Assertions.assertEquals(gameD4, RectCoordinateConverter.toGameCoord(RectCoordinateConverter.toDisplayCoord(gameD4, boardSize), boardSize));
        }

    }


}