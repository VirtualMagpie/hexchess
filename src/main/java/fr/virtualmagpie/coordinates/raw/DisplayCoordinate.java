package fr.virtualmagpie.coordinates.raw;

import java.util.Objects;

/**
 * Coordinate to be used for display purpose. (0, 0) represents something to be displayed in the upper-left corner of
 * the screen. From (x, y) coordinate, (x+1, y) is something to be displayed on the right, and (x, y+1) is something to
 * be displayed below. This coordinate do not take into account screen size, so a coefficient may be applied before
 * printing to get the real number of pixel to print.
 */
public class DisplayCoordinate {
    private final int x;
    private final int y;

    public DisplayCoordinate(int x, int y) {
        if (x < 0 || y < 0) {
            throw new IllegalArgumentException("x and y must be positive");
        }
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public String toString() {
        return String.format("(%s,%s)", x, y);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DisplayCoordinate that = (DisplayCoordinate) o;
        return x == that.x && y == that.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
