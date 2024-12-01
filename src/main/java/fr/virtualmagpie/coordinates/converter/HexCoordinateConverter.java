package fr.virtualmagpie.coordinates.converter;

import fr.virtualmagpie.coordinates.raw.DisplayCoordinate;
import fr.virtualmagpie.coordinates.raw.EfficientHexCoordinate;
import fr.virtualmagpie.coordinates.raw.GameCoordinate;

/**
 * Utils class to convert among different coordinate systems given a hex grid
 *
 * <p>Example</p>
 *
 * <pre>
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
 * </pre>
 */
public class HexCoordinateConverter {

    private HexCoordinateConverter() {}

    public static GameCoordinate toGameCoord(DisplayCoordinate displayCoord, int boardSize) {
        if (Math.floorMod(displayCoord.getX() + displayCoord.getY(), 2) != 0) {
            throw new IllegalArgumentException("Invalid display coordinate for hex board: x+y is supposed to be even.");
        }
        return null; // TODO JDE
    }

    public static GameCoordinate toGameCoord(EfficientHexCoordinate efficientCoord, int boardSize) {
        int col = efficientCoord.getC() * 2 + efficientCoord.getA() + 1;
        int row = (boardSize * 2 - 1) - efficientCoord.getR() - Math.abs(boardSize - 1 - efficientCoord.getC());
        return null; // TODO JDE
    }

    public static DisplayCoordinate toDisplayCoord(GameCoordinate gameCoord, int boardSize) {
        return null; // TODO JDE
    }

    public static DisplayCoordinate toDisplayCoord(EfficientHexCoordinate efficientCoord) {
        int x = efficientCoord.getC() * 2 + efficientCoord.getA();
        int y = efficientCoord.getR() * 2 + efficientCoord.getA();
        return new DisplayCoordinate(x, y);
    }

    public static EfficientHexCoordinate toEfficientHexCoord(DisplayCoordinate displayCoord) {
        if (Math.floorMod(displayCoord.getX() + displayCoord.getY(), 2) != 0) {
            throw new IllegalArgumentException("Invalid display coordinate for hex board: x+y is supposed to be even.");
        }
        int a = Math.floorMod(displayCoord.getX(), 2);
        int r = displayCoord.getY() / 2;
        int c = displayCoord.getX() / 2;
        return new EfficientHexCoordinate(a, r, c);
    }

    public static EfficientHexCoordinate toEfficientHexCoord(GameCoordinate gameCoord, int boardSize) {
        return null; // TODO JDE
    }
}
