package fr.virtualmagpie.board;

import java.awt.*;

/**
 * {@see https://en.wikipedia.org/wiki/Hexagonal_Efficient_Coordinate_System}
 */
public class HexBoard implements Board {

    final int MAX_COL = 8;
    final int MAX_ROW = 8;

    public static final int BASE_SIZE = 100;
    public static final int HEX_SIDE_SIZE = BASE_SIZE / 2;
    public static final int HEX_HALF_HEIGHT_SIZE = ((Double) ((Math.sqrt(3D) / 2) * HEX_SIDE_SIZE)).intValue();

    private final Color BLACK = new Color(50, 50, 50);
    private final Color GRAY = new Color(135, 135, 135);
    private final Color WHITE = new Color(220, 220, 220);

    private final Color TEST_COLOR = new Color(255, 0, 0);
    private final int TEST_COL = 3;
    private final int TEST_ROW = 1;

    public void draw(Graphics2D g2) {
        for (int row = 0; row < MAX_ROW; row++) {
            for (int col = 0; col < MAX_COL; col++) {
                // alt false
                g2.setColor(colorFromCoordinate(false, row, col));
                g2.fillPolygon(hexFromCoordinate(false, row, col));
                // alt true
                g2.setColor(colorFromCoordinate(true, row, col));
                g2.fillPolygon(hexFromCoordinate(true, row, col));
            }
        }
    }

    // TODO JDE: maybe invert row/col
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
    private Polygon hexFromCoordinate(boolean alt, int row, int col) {

        int xExtL = col * (BASE_SIZE + HEX_SIDE_SIZE) + (alt ? HEX_SIDE_SIZE * 3 / 2 : 0);
        int xL = xExtL + HEX_SIDE_SIZE / 2;
        int xR = xExtL + HEX_SIDE_SIZE + HEX_SIDE_SIZE / 2;
        int xExtR = xExtL + 2 * HEX_SIDE_SIZE;

        int yUp = row * 2 * HEX_HALF_HEIGHT_SIZE + (alt ? HEX_HALF_HEIGHT_SIZE : 0);
        int yMid = yUp + HEX_HALF_HEIGHT_SIZE;
        int yBot = yUp + 2 * HEX_HALF_HEIGHT_SIZE;

        int[] xPoints = { xExtL, xL, xR, xExtR, xR, xL };
        int[] yPoints = { yMid, yUp, yUp, yMid, yBot, yBot };

        return new Polygon(xPoints, yPoints, 6);
    }

    private Color colorFromCoordinate(boolean alt, int row, int col) {
        int baseCycle = (alt ? row + 2 : row) % 3;

        if (baseCycle == 0) {
            return BLACK;
        } else if (baseCycle == 1) {
            return GRAY;
        } else {
            return WHITE;
        }
    }
}
