package fr.virtualmagpie.board;

import fr.virtualmagpie.board.shape.RectangleProvider;
import fr.virtualmagpie.board.shape.ShapeProvider;

import java.awt.*;

public class RectBoard implements Board {

    private static final Color BLACK = new Color(175, 115, 70);
    private static final Color WHITE = new Color(210, 165, 125);
    private static final int MAX_COL = 8;
    private static final int MAX_ROW = 8;
    private static final int SQUARE_SIZE = 100;

    private final ShapeProvider[][] gridShapes;

    public RectBoard() {
        gridShapes = buildGridShapes(MAX_COL, MAX_ROW, SQUARE_SIZE, new Color[]{ BLACK, WHITE });
    }

    public void draw(Graphics2D g2) {
        for (ShapeProvider[] rowShapes: gridShapes) {
            for (ShapeProvider shape: rowShapes) {
                g2.setColor(shape.getColor());
                g2.fillPolygon(shape.getPolygon());
            }
        }
    }

    private static ShapeProvider[][] buildGridShapes(int nbCol, int nbRow, int squareSize, Color[] colors) {
        ShapeProvider[][] gridShapes = new ShapeProvider[nbCol][nbRow];
        for (int col = 0; col < nbCol; col++) {
            for (int row = 0; row < nbRow; row++) {
                gridShapes[col][row] = new RectangleProvider(
                        col * squareSize, row * squareSize,
                        squareSize, squareSize,
                        colors[(col + row) % 2]
                );
            }
        }
        return gridShapes;
    }
}
