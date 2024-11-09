package fr.virtualmagpie.board.shape;

import java.awt.*;

public class RectangleProvider implements ShapeProvider {

    private final int xOffset;
    private final int yOffset;
    private final int width;
    private final int height;
    private final Color color;

    private Polygon polygon;

    public RectangleProvider(int xOffset, int yOffset, int width, int height, Color color) {
        this.xOffset = xOffset;
        this.yOffset = yOffset;
        this.width = width;
        this.height = height;
        this.color = color;
    }

    @Override
    public Color getColor() {
        return color;
    }

    @Override
    public Polygon getPolygon() {
        if (polygon == null) {
            polygon = buildPolygon();
        }
        return polygon;
    }

    private Polygon buildPolygon() {
        int[] xPoints = { xOffset, xOffset + width, xOffset + width, xOffset };
        int[] yPoints = { yOffset, yOffset, yOffset + height, yOffset + height };

        return new Polygon(xPoints, yPoints, 4);
    }
}
