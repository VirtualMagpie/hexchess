package fr.virtualmagpie.board.shape;

import java.awt.*;

public class HexagonProvider implements ShapeProvider {

    private final int xOffset;
    private final int yOffset;
    private final int width;
    private final int height;
    private final Color color;

    private Polygon polygon;

    public HexagonProvider(int xOffset, int yOffset, int width, int height, Color color) {
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

    /*
     *            *********              "Up" row
     *          *           *
     *        *               *
     *      *                   *        "Mid" row
     *        *               *
     *          *           *
     *            *********              "Bot" row
     *
     *    "ExtL"  "L"     "R"  "ExtR"
     *      col   col     col   col
     */
    private Polygon buildPolygon() {
        int xExtL = xOffset;
        int xL = xOffset + (width / 4);
        int xR = xOffset + (3 * width / 4);
        int xExtR = xOffset + width;

        int yUp = yOffset;
        int yMid = yOffset + (height / 2);
        int yBot = yOffset + height;

        int[] xPoints = { xExtL, xL, xR, xExtR, xR, xL };
        int[] yPoints = { yMid, yUp, yUp, yMid, yBot, yBot };

        return new Polygon(xPoints, yPoints, 6);
    }
}
