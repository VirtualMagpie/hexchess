package fr.virtualmagpie.coordinates;

/**
 * <ul>
 *     This class is supposed to store (and allow conversion among) multiple kinds of coordinate system:
 *     <li>
 *         "Display coordinate" - Coordinate to be used for display purpose. (0, 0) represents something to be
 *         displayed at the upper left corner of the screen. From (x, y) coordinate, (x+1, y) is something to be
 *         displayed on the right, and (x, y+1) is something to be displayed below. This coordinate do not take into
 *         account screen size, so a coefficient may be applied before printing to get the real number of pixel to
 *         print.
 *     </li>
 *     <li>
 *         "Game coordinate" - Represents a coordinate as defined in games rules. Officially those coordinates are
 *         using letters (a1, c3, etc...), but they will instead be stored as integer. Conversion into letter is only
 *         performed when needed to to displayed. Beware: it seems that letter j is not officially used in those
 *         coordinates (so (1,1) is displayed as "a1", (9,1) is displayed as "i1", but (10,1) is displayed as "k1").
 *         Nota: Because game coordinate depends on board size (c1 is "above" b1 in a board of size 2, but below b1 in
 *         a board of size 3+), game coordinate also include a value for board size.
 *     </li>
 *     <li>"Efficient coordinate" - {@see https://en.wikipedia.org/wiki/Hexagonal_Efficient_Coordinate_System}</li>
 * </ul>
 *
 * <p>Example for a board of size 3</p>
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
 *
 * <p>Nota: Game coordinate will be stored using integer. Letters will only be used for display purpose.
 *
 * <p>Nota: Because game coordinate depends on board size (c1 is "above" b1 in a board of size 2, but below b1 in a
 * board of size 3+), game coordinate also include a value for board size.
 *
 * <p>Be aware that, given hex board shape, some coordinate may not be valid. For instance, on a classic hex-board,
 * which has a 6 cells on each size, "column" is a value between "a" (1) and "l" (11), and "row" is a value from 1 to
 * 11. However, even if colum "f" has rows from 1 to 11, column "a" on the contrary has only rows from 1 to 6.
 *
 * <p>Example for a board of size 6 (ie official board) - using game coordinates</p>
 *
 * <pre>
 *                              f11
 *                          e10     g10
 *                      d9      f10     h9
 *                  c8      e9      g9      i8
 *              b7      d8      f9      h8      k7
 *          a6      c7      e8      g8      i7      l6
 *              b6      d7      f8      h7      k6
 *          a5      c6      e7      g7      i6      l5
 *              b5      d6      f7      h6      k5
 *          a4      c5      e6      g6      i5      l4
 *              b4      d5      f6      h5      k4
 *          a3      c4      e5      g5      i4      l3
 *              b3      d4      f5      h4      k3
 *          a2      c3      e4      g4      i3      l2
 *              b2      d3      f4      h3      k2
 *          a1      c2      e3      g3      i2      l1
 *              b1      d2      f3      h2      k1
 *                  c1      e2      g2      i1
 *                      d1      f2      h1
 *                          e1      g1
 *                              f1
 * </pre>
 */
public class HexCoordinate {

    // Storage using efficient coordinate system
    int a;
    int r;
    int c;

    private HexCoordinate(int a, int r, int c) {
        this.a = a;
        this.r = r;
        this.c = c;
    }

    ///////////////////////////
    // efficient coordinates //
    ///////////////////////////

    public static HexCoordinate fromEfficientCoordinates(int a, int r, int c) {
        return new HexCoordinate(a, r, c);
    }

    public int getEfficientCoordinateA() {
        return a;
    }

    public int getEfficientCoordinateR() {
        return r;
    }

    public int getEfficientCoordinateC() {
        return c;
    }

    ////////////
    //

    /**
     * <pre>
     *              Display                                  Efficient
     *
     *                2,0                                      0,0,1
     *          1,1         3,1                          1,0,0       1,0,1
     *    0,2         2,2         4,2              0,1,0       0,1,1       0,1,2
     *          1,3         3,3                          1,1,0       1,1,1
     *    0,4         2,4         4,4              0,2,0       0,2,1       0,2,2
     *          1,5         3,5                          1,2,0       1,2,1
     *    0,6         2,6         4,6              0,3,0       0,3,1       0,3,2
     *          1,7         3,7                          1,3,0       1,3,1
     *                2,8                                      0,4,1
     *
     *
     *           0,0 =>  0,0,0
     *           2,0 =>  0,0,1
     *           0,2 =>  0,1,0
     *           2,2 =>  0,1,1
     *           1,1 =>  1,0,0
     *           1,3 =>  1,1,0
     *           3,1 =>  1,0,1
     *           3,3 =>  1,1,1
     *
     * </pre>
     */

    public static HexCoordinate fromDisplayCoordinates(int x, int y) {
        if (Math.floorMod(x + y, 2) != 0) {
            throw new IllegalArgumentException("Invalid display coordinate for hex board: x+y is supposed to be even.");
        }
        int a = Math.floorMod(x, 2);
        int r = y / 2;
        int c = x / 2;
        return new HexCoordinate(a, r, c);
    }

    public static HexCoordinate fromGameCoordinates(int x, int y) {
        return null; // TODO JDE
    }

}
