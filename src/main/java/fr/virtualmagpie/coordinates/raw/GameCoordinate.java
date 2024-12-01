package fr.virtualmagpie.coordinates.raw;

import java.util.Objects;

/**
 * Represents a coordinate as defined in games rules. Officially those coordinates are using letters (a1, c3, etc...),
 * but they will instead be stored as integer. Conversion into letter is only performed when needed to be displayed.
 *
 * <p> Beware: it seems that letter j is not officially used in those coordinates (so (1,1) is displayed as "a1", (9,1)
 * is displayed as "i1", but (10,1) is displayed as "k1").
 *
 * <p>Example
 *
 * <pre>
 *
 *         Rect grid                                Hex grid
 *
 *    a4    b4    c4    d4                              c5
 *                                                b4          d4
 *    a3    b3    c3    d3                  a3          c4          e3
 *                                                b3          d3
 *    a2    b2    c2    d2                  a2          c3          e2
 *                                                b2          d2
 *    a1    b1    c1    d1                  a1          c2          e1
 *                                                b1          d1
 *                                                      c1
 * </pre>
 */
public class GameCoordinate {
    private static final String[] letters = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u"};

    private final int col;
    private final int row;

    public GameCoordinate(int col, int row) {
        if (col < 1 || row < 1) {
            throw new IllegalArgumentException("col and row must be strictly positive");
        }
        if (col > letters.length) {
            throw new IllegalArgumentException("col must must inferior or equal to " + letters.length);
        }
        this.col = col;
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public int getRow() {
        return row;
    }

    public String getColLetter() {
        return letters[col - 1];
    }

    @Override
    public String toString() {
        return getColLetter() + row;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GameCoordinate that = (GameCoordinate) o;
        return col == that.col && row == that.row;
    }

    @Override
    public int hashCode() {
        return Objects.hash(col, row);
    }
}
