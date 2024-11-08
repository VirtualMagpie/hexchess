package fr.virtualmagpie.board;

import java.awt.*;

public class RectBoard implements Board {

    final int MAX_COL = 8;
    final int MAX_ROW = 8;

    public static final int SQUARE_SIZE = 100;
    public static final int HALF_SQUARE_SIZE = SQUARE_SIZE/2;

    private final Color BLACK = new Color(175, 115, 70);
    private final Color WHITE = new Color(210, 165, 125);

    public void draw(Graphics2D g2) {
        boolean isBlack = false;
        for (int row = 0; row < MAX_ROW; row++) {
            for (int col = 0; col < MAX_COL; col++) {
                if (isBlack) {
                    g2.setColor(BLACK);
                } else {
                    g2.setColor(WHITE);
                }
                g2.fillRect(col * SQUARE_SIZE, row * SQUARE_SIZE, SQUARE_SIZE, SQUARE_SIZE);
                isBlack = !isBlack;
            }
            isBlack = !isBlack;
        }
    }
}
