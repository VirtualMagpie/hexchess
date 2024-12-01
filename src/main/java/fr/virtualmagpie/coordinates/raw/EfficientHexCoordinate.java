package fr.virtualmagpie.coordinates.raw;

import java.util.Objects;

/**
 * {@see https://en.wikipedia.org/wiki/Hexagonal_Efficient_Coordinate_System}
 */
public class EfficientHexCoordinate {

    private final int a;
    private final int r;
    private final int c;

    public EfficientHexCoordinate(int a, int r, int c) {
        if (a != 0 && a != 1) {
            throw new IllegalArgumentException("a must be in {0,1}");
        }
        this.a = a;
        this.r = r;
        this.c = c;
    }

    public int getA() {
        return a;
    }

    public int getR() {
        return r;
    }

    public int getC() {
        return c;
    }

    @Override
    public String toString() {
        return String.format("(%s,%s,%s)", a, r, c);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EfficientHexCoordinate that = (EfficientHexCoordinate) o;
        return a == that.a && r == that.r && c == that.c;
    }

    @Override
    public int hashCode() {
        return Objects.hash(a, r, c);
    }
}
