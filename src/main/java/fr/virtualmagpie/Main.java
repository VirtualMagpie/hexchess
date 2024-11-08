package fr.virtualmagpie;

import javax.swing.*;

// Based on this tuto: https://www.youtube.com/watch?v=jzCxywhTAUI
public class Main {
    public static void main(String[] args) {

        JFrame window = new JFrame("Hex Chess");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);

        // Add GamePanel to the window
        GamePanel gp = new GamePanel();
        window.add(gp);
        window.pack();

        window.setLocationRelativeTo(null);
        window.setVisible(true);

        gp.launchGame();
    }
}