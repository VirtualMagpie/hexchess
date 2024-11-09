package fr.virtualmagpie.board;

import fr.virtualmagpie.board.color.ColorTheme;
import fr.virtualmagpie.board.shape.HexagonProvider;
import fr.virtualmagpie.board.shape.ShapeProvider;

import java.awt.*;

/**
 * {@see https://en.wikipedia.org/wiki/Hexagonal_Efficient_Coordinate_System}
 */
public class HexBoard implements Board {

    private static final int MAX_COL = 6;
    private static final int MAX_ROW = 11;
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
