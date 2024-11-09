package fr.virtualmagpie.coordinates;

/**
 * Represents a coordinate in vanilla chess. Such coordinates starts at index 1, and typically starts from the
 * lower-left square on the screen.
 *
 * <p>Multiple methods allows to switch to other technical coordinates (which are used for display for example).
 */
public class RectCoordinate {
    int column; // represented as letter instead in real notation
    int row;

    public RectCoordinate(int column, int row) {
        this.column = column;
        this.row = row;
    }

    // (1, 1) is represented as "a1"
    public String toString() {
        return String.valueOf((char)(column + 96)) + row;
    }

    /**
     * Convert to coordinates used by display. Typically on a 8x8 grid, cell "a8" is in the upper-left corner, and is
     * indeed at coordinate {0,0} in display-coordinate. "a1" is at {0,7}, and "h1" is at {7,7}
     *
     * @param gridSize - number of row/column in the board grid (8 for a normal chess board)
     *
     * @return 2-cells array
     */
    public int[] toDisplayCoordinate(int gridSize) {
        return new int[]{ column - 1, gridSize - row };
    }
}
