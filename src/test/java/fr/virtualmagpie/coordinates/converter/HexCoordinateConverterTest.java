package fr.virtualmagpie.coordinates.converter;

import fr.virtualmagpie.coordinates.raw.DisplayCoordinate;
import fr.virtualmagpie.coordinates.raw.EfficientHexCoordinate;
import fr.virtualmagpie.coordinates.raw.GameCoordinate;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class HexCoordinateConverterTest {

    /*
     *              Display                                Game                                Efficient
     *
     *                2,0                                   c5                                   0,0,1
     *          1,1         3,1                       b4          d4                       1,0,0       1,0,1
     *    0,2         2,2         4,2           a3          c4          e3           0,1,0       0,1,1       0,1,2
     *          1,3         3,3                       b3          d3                       1,1,0       1,1,1
     *    0,4         2,4         4,4           a2          c3          e2           0,2,0       0,2,1       0,2,2
     *          1,5         3,5                       b2          d2                       1,2,0       1,2,1
     *    0,6         2,6         4,6           a1          c2          e1           0,3,0       0,3,1       0,3,2
     *          1,7         3,7                       b1          d1                       1,3,0       1,3,1
     *                2,8                                   c1                                   0,4,1
     */
    @Nested
    class Grid3 {

        int boardSize = 4;

        DisplayCoordinate display24 = new DisplayCoordinate(2, 4);
        DisplayCoordinate display33 = new DisplayCoordinate(3, 3);
        DisplayCoordinate display02 = new DisplayCoordinate(0, 2);
        DisplayCoordinate display06 = new DisplayCoordinate(0, 6);
        DisplayCoordinate display28 = new DisplayCoordinate(2, 8);
        DisplayCoordinate display46 = new DisplayCoordinate(4, 6);
        DisplayCoordinate display42 = new DisplayCoordinate(4, 2);
        DisplayCoordinate display20 = new DisplayCoordinate(2, 0);

        GameCoordinate gameC3 = new GameCoordinate(3, 3);
        GameCoordinate gameD3 = new GameCoordinate(4, 3);
        GameCoordinate gameA3 = new GameCoordinate(1, 3);
        GameCoordinate gameA1 = new GameCoordinate(1, 1);
        GameCoordinate gameC1 = new GameCoordinate(3, 1);
        GameCoordinate gameE1 = new GameCoordinate(5, 1);
        GameCoordinate gameE3 = new GameCoordinate(5, 3);
        GameCoordinate gameC5 = new GameCoordinate(3, 5);

        EfficientHexCoordinate efficient021 = new EfficientHexCoordinate(0, 2, 1);
        EfficientHexCoordinate efficient111 = new EfficientHexCoordinate(1, 1, 1);
        EfficientHexCoordinate efficient010 = new EfficientHexCoordinate(0, 1, 0);
        EfficientHexCoordinate efficient030 = new EfficientHexCoordinate(0, 3, 0);
        EfficientHexCoordinate efficient041 = new EfficientHexCoordinate(0, 4, 1);
        EfficientHexCoordinate efficient032 = new EfficientHexCoordinate(0, 3, 2);
        EfficientHexCoordinate efficient012 = new EfficientHexCoordinate(0, 1, 2);
        EfficientHexCoordinate efficient001 = new EfficientHexCoordinate(0, 0, 1);

        @Test
        void fromDisplayToGame() {
            Assertions.assertEquals(gameC3, HexCoordinateConverter.toGameCoord(display24, boardSize));
            Assertions.assertEquals(gameD3, HexCoordinateConverter.toGameCoord(display33, boardSize));
            Assertions.assertEquals(gameA3, HexCoordinateConverter.toGameCoord(display02, boardSize));
            Assertions.assertEquals(gameA1, HexCoordinateConverter.toGameCoord(display06, boardSize));
            Assertions.assertEquals(gameC1, HexCoordinateConverter.toGameCoord(display28, boardSize));
            Assertions.assertEquals(gameE1, HexCoordinateConverter.toGameCoord(display46, boardSize));
            Assertions.assertEquals(gameE3, HexCoordinateConverter.toGameCoord(display42, boardSize));
            Assertions.assertEquals(gameC5, HexCoordinateConverter.toGameCoord(display20, boardSize));
        }

        @Test
        void fromEfficientToGame() {
            Assertions.assertEquals(gameC3, HexCoordinateConverter.toGameCoord(efficient021, boardSize));
            Assertions.assertEquals(gameD3, HexCoordinateConverter.toGameCoord(efficient111, boardSize));
            Assertions.assertEquals(gameA3, HexCoordinateConverter.toGameCoord(efficient010, boardSize));
            Assertions.assertEquals(gameA1, HexCoordinateConverter.toGameCoord(efficient030, boardSize));
            Assertions.assertEquals(gameC1, HexCoordinateConverter.toGameCoord(efficient041, boardSize));
            Assertions.assertEquals(gameE1, HexCoordinateConverter.toGameCoord(efficient032, boardSize));
            Assertions.assertEquals(gameE3, HexCoordinateConverter.toGameCoord(efficient012, boardSize));
            Assertions.assertEquals(gameC5, HexCoordinateConverter.toGameCoord(efficient001, boardSize));
        }

        @Test
        void fromGameToDisplay() {
            Assertions.assertEquals(display24, HexCoordinateConverter.toDisplayCoord(gameC3, boardSize));
            Assertions.assertEquals(display33, HexCoordinateConverter.toDisplayCoord(gameD3, boardSize));
            Assertions.assertEquals(display02, HexCoordinateConverter.toDisplayCoord(gameA3, boardSize));
            Assertions.assertEquals(display06, HexCoordinateConverter.toDisplayCoord(gameA1, boardSize));
            Assertions.assertEquals(display28, HexCoordinateConverter.toDisplayCoord(gameC1, boardSize));
            Assertions.assertEquals(display46, HexCoordinateConverter.toDisplayCoord(gameE1, boardSize));
            Assertions.assertEquals(display42, HexCoordinateConverter.toDisplayCoord(gameE3, boardSize));
            Assertions.assertEquals(display20, HexCoordinateConverter.toDisplayCoord(gameC5, boardSize));
        }

        @Test
        void fromEfficientToDisplay() {
            Assertions.assertEquals(display24, HexCoordinateConverter.toDisplayCoord(efficient021));
            Assertions.assertEquals(display33, HexCoordinateConverter.toDisplayCoord(efficient111));
            Assertions.assertEquals(display02, HexCoordinateConverter.toDisplayCoord(efficient010));
            Assertions.assertEquals(display06, HexCoordinateConverter.toDisplayCoord(efficient030));
            Assertions.assertEquals(display28, HexCoordinateConverter.toDisplayCoord(efficient041));
            Assertions.assertEquals(display46, HexCoordinateConverter.toDisplayCoord(efficient032));
            Assertions.assertEquals(display42, HexCoordinateConverter.toDisplayCoord(efficient012));
            Assertions.assertEquals(display20, HexCoordinateConverter.toDisplayCoord(efficient001));
        }

        @Test
        void fromGameToEfficient() {
            Assertions.assertEquals(efficient021, HexCoordinateConverter.toEfficientHexCoord(gameC3, boardSize));
            Assertions.assertEquals(efficient111, HexCoordinateConverter.toEfficientHexCoord(gameD3, boardSize));
            Assertions.assertEquals(efficient010, HexCoordinateConverter.toEfficientHexCoord(gameA3, boardSize));
            Assertions.assertEquals(efficient030, HexCoordinateConverter.toEfficientHexCoord(gameA1, boardSize));
            Assertions.assertEquals(efficient041, HexCoordinateConverter.toEfficientHexCoord(gameC1, boardSize));
            Assertions.assertEquals(efficient032, HexCoordinateConverter.toEfficientHexCoord(gameE1, boardSize));
            Assertions.assertEquals(efficient012, HexCoordinateConverter.toEfficientHexCoord(gameE3, boardSize));
            Assertions.assertEquals(efficient001, HexCoordinateConverter.toEfficientHexCoord(gameC5, boardSize));
        }

        @Test
        void fromDisplayToEfficient() {
            Assertions.assertEquals(efficient021, HexCoordinateConverter.toEfficientHexCoord(display24));
            Assertions.assertEquals(efficient111, HexCoordinateConverter.toEfficientHexCoord(display33));
            Assertions.assertEquals(efficient010, HexCoordinateConverter.toEfficientHexCoord(display02));
            Assertions.assertEquals(efficient030, HexCoordinateConverter.toEfficientHexCoord(display06));
            Assertions.assertEquals(efficient041, HexCoordinateConverter.toEfficientHexCoord(display28));
            Assertions.assertEquals(efficient032, HexCoordinateConverter.toEfficientHexCoord(display46));
            Assertions.assertEquals(efficient012, HexCoordinateConverter.toEfficientHexCoord(display42));
            Assertions.assertEquals(efficient001, HexCoordinateConverter.toEfficientHexCoord(display20));
        }
    }

    /*
     *              Display                                Game                                Efficient
     *
     *                1,0                                   b3                                   1,0,0
     *          0,1         2,1                       a1          c2                       0,1,0       0,1,1
     *                1,2                                   b2                                   1,1,0
     *          0,3         2,3                       a1          c1                       0,2,0       0,2,1
     *                1,4                                   b1                                   1,2,0
     */
    @Nested
    class Grid2 {
        // TODO JDE
    }
}