package main;

import javax.swing.*;

public class Main {

    public static void main(String[] args){

        JFrame window = new JFrame();
        GamePanel gamePanel = new GamePanel();

        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setTitle("Pacman");
        window.setIconImage(new ImageIcon("src/assets/icon.png").getImage());

        window.add(gamePanel);
        window.pack();

        window.setSize(gamePanel.screenWidth, gamePanel.screenHeight);
        window.setResizable(true);

        window.setLocationRelativeTo(null);
        window.setVisible(true);

        gamePanel.startGameThread();

    }

}
