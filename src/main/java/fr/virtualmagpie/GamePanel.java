package fr.virtualmagpie;

import fr.virtualmagpie.board.Board;
import fr.virtualmagpie.board.HexBoard;
import fr.virtualmagpie.board.RectBoard;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable {

    public static final int WIDTH = 1600;
    public static final int HEIGHT = 900;
    final int FPS = 60;
    Thread gameThread;
    Board board = new HexBoard();

    public GamePanel() {
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setBackground(Color.BLACK);
    }

    public void launchGame() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {

        // GAME LOOP
        double drawInterval = 1_000_000_000D / FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;

        while (gameThread != null) {
            currentTime = System.nanoTime();

            delta += (currentTime - lastTime) / drawInterval;
            lastTime = currentTime;

            if (delta >= 1) {
                update();
                repaint();
                delta--;
            }
        }
    }

    private void update() {}

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;
        board.draw(g2);
    }
}
