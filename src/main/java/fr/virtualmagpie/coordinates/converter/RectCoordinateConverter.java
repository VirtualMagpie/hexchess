package fr.virtualmagpie.coordinates.converter;

import fr.virtualmagpie.coordinates.raw.DisplayCoordinate;
import fr.virtualmagpie.coordinates.raw.GameCoordinate;

/**
 * Utils class to convert among different coordinate systems given a rect grid
 *
 * <p>Example</p>
 *
 * <pre>
 *              Display                                Game
 *
 *     0,0    1,0    2,0    3,0               a4     b4     c4     d4
 *
 *     0,1    1,1    2,1    3,1               a3     b3     c3     d3
 *
 *     0,2    1,2    2,2    3,2               a2     b2     c2     d2
 *
 *     0,3    1,3    2,3    3,3               a1     b1     c1     d1
 * </pre>
 */
public class RectCoordinateConverter {

    private RectCoordinateConverter() {}

    public static GameCoordinate toGameCoord(DisplayCoordinate displayCoord, int boardSize) {
        int col = displayCoord.getX() + 1;
        int row = boardSize - displayCoord.getY();
        return new GameCoordinate(col, row);
    }

    public static DisplayCoordinate toDisplayCoord(GameCoordinate gameCoord, int boardSize) {
        int x = gameCoord.getCol() - 1;
        int y = boardSize - gameCoord.getRow();
        return new DisplayCoordinate(x, y);
    }
}
