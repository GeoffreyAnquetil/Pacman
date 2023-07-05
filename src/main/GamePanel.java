package main;

import entities.Player;
import map.TileManager;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable {

    // Screen settings
    final int unscaledTileSize = 24;
    final int scale = 1;

    public final int tileSize = unscaledTileSize * scale;
    public final int maxScreenCol = 28;
    public final int maxScreenRow = 31;
    final int screenWidth = tileSize * maxScreenCol + 15;
    final int screenHeight = tileSize * maxScreenRow + 40;

    KeyHandler keyHandler = new KeyHandler();
    Thread gameThread;
    TileManager tileManager = new TileManager(this);

    Player player = new Player(this, keyHandler, tileManager);

    public GamePanel(){
        this.setSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyHandler);
        this.setFocusable(true);
    }

    public void startGameThread(){
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {

        double drawInterval = 1_000_000_000/60;
        double nextDrawTime = System.nanoTime() + drawInterval;

        while(gameThread != null){

            //Update en position
            update();

            //Update Graphique
            repaint();

            try{
                double remainingTime = nextDrawTime - System.nanoTime();
                remainingTime = remainingTime/1_000_000;
                if(remainingTime < 0) remainingTime = 0;

                Thread.sleep((long) remainingTime);

                nextDrawTime += drawInterval;

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }

    }

    public void update(){

        player.update();

    }

    @Override
    public void paintComponent(Graphics g){

        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D)g;
        g2.setColor(Color.white);

        // Dessin de la carte
        tileManager.drawmap(g2);

        player.draw(g2);

        g2.dispose();

    }

}
