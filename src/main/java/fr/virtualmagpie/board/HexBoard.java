package fr.virtualmagpie.board;

import fr.virtualmagpie.board.color.ColorTheme;
import fr.virtualmagpie.board.shape.HexagonProvider;
import fr.virtualmagpie.board.shape.ShapeProvider;

import java.awt.*;

/**
 * {@see https://en.wikipedia.org/wiki/Hexagonal_Efficient_Coordinate_System}
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
public class HexBoard implements Board {

    private static final int MAX_COL = 4;
    private static final int MAX_ROW = 7;
    private static final int HEX_WIDTH = 88; // size of full hex width (so 2x side size)
    private static final int HEX_HEIGHT = ((Double) ((Math.sqrt(3D) / 2) * HEX_WIDTH)).intValue();

    private final ShapeProvider[][][] biGridShapes;

    public HexBoard(ColorTheme colorTheme) {
        this.biGridShapes = buildBiGridShapes(MAX_COL, MAX_ROW, HEX_WIDTH, HEX_HEIGHT,
                new Color[]{ colorTheme.primary(), colorTheme.secondary(), colorTheme.tertiary() });
    }

    public void draw(Graphics2D g2) {
        for (ShapeProvider[][] gridShapes: biGridShapes) {
            for (ShapeProvider[] rowShapes: gridShapes) {
                for (ShapeProvider shape: rowShapes) {
                    g2.setColor(shape.getColor());
                    g2.fillPolygon(shape.getPolygon());
                }
            }
        }
    }

    private ShapeProvider[][][] buildBiGridShapes(int nbCol, int nbRow, int hexWidth, int hexHeight, Color[] colors) {
        ShapeProvider[][][] biGridShapes = new ShapeProvider[2][nbCol][nbRow];
        for (int alt = 0; alt < 2; alt++) {
            for (int col = 0; col < nbCol; col++) {
                for (int row = 0; row < nbRow; row++) {
                    biGridShapes[alt][col][row] = new HexagonProvider(
                            col * (3 * hexWidth / 2) + alt * (3 * hexWidth / 4),
                            row * hexHeight + alt * (hexHeight / 2),
                            hexWidth, hexHeight,
                            colors[(row - alt + 3) % 3]
                    );
                }
            }
        }
        return biGridShapes;
    }
}
