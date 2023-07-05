package entities;

import main.GamePanel;
import main.KeyHandler;
import map.TileManager;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Player extends Entity {

    private int xPos, yPos;
    private int speed;

    private BufferedImage up1, up2, up3, up4;
    private BufferedImage down1, down2, down3, down4;
    private BufferedImage left1, left2, left3, left4;
    private BufferedImage right1, right2, right3, right4;

    private Direction direction;

    private int spriteCounter = 0;
    private int spriteNum = 1;

    GamePanel gamePanel;
    KeyHandler keyHandler;
    TileManager tileManager;

    public Player(GamePanel gp, KeyHandler kh, TileManager tm) {

        gamePanel = gp;
        keyHandler = kh;
        tileManager = tm;

        xPos = 100;
        yPos = 100;
        speed = 3; // Pixel/sec

        direction = Direction.LEFT;

        try {
            up1 = ImageIO.read(new File("src/assets/Player/pacman_UP_1.png"));
            up2 = ImageIO.read(new File("src/assets/Player/pacman_UP_2.png"));
            up3 = ImageIO.read(new File("src/assets/Player/pacman_UP_3.png"));
            up4 = up2;

            down1 = ImageIO.read(new File("src/assets/Player/pacman_DOWN_1.png"));
            down2 = ImageIO.read(new File("src/assets/Player/pacman_DOWN_2.png"));
            down3 = ImageIO.read(new File("src/assets/Player/pacman_DOWN_3.png"));
            down4 = down2;

            left1 = ImageIO.read(new File("src/assets/Player/pacman_LEFT_1.png"));
            left2 = ImageIO.read(new File("src/assets/Player/pacman_LEFT_2.png"));
            left3 = ImageIO.read(new File("src/assets/Player/pacman_LEFT_3.png"));
            left4 = left2;

            right1 = ImageIO.read(new File("src/assets/Player/pacman_RIGHT_1.png"));
            right2 = ImageIO.read(new File("src/assets/Player/pacman_RIGHT_2.png"));
            right3 = ImageIO.read(new File("src/assets/Player/pacman_RIGHT_3.png"));
            right4 = right2;

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void update() {
        // Player movement
        if (keyHandler.upPressed) {
            moveUp();
            direction = Direction.UP;
        } else if (keyHandler.downPressed) {
            moveDown();
            direction = Direction.DOWN;
        } else if (keyHandler.rightPressed) {
            moveRight();
            direction = Direction.RIGHT;
        } else if (keyHandler.leftPressed) {
            moveLeft();
            direction = Direction.LEFT;
        }
    }

    public void draw(Graphics2D g2) {
        BufferedImage image = null;

        switch (direction) {
            case UP -> {
                switch(spriteNum){
                    case 0 -> image = up1;
                    case 1 -> image = up2;
                    case 2 -> image = up3;
                    case 3 -> image = up4;
                }
            }
            case DOWN -> {
                switch(spriteNum){
                    case 0 -> image = down1;
                    case 1 -> image = down2;
                    case 2 -> image = down3;
                    case 3 -> image = down4;
                }
            }
            case LEFT -> {
                switch(spriteNum){
                    case 0 -> image = left1;
                    case 1 -> image = left2;
                    case 2 -> image = left3;
                    case 3 -> image = left4;
                }
            }
            case RIGHT -> {
                switch(spriteNum){
                    case 0 -> image = right1;
                    case 1 -> image = right2;
                    case 2 -> image = right3;
                    case 3 -> image = right4;
                }
            }
        }
        g2.drawImage(image, xPos, yPos, gamePanel.tileSize, gamePanel.tileSize, null);
        spriteCounter += 1;
        if(spriteCounter > 10){
            spriteNum = (spriteNum + 1)%4;
            spriteCounter = 0;
        }
    }

    public void moveUp() {
        yPos -= speed;
    }

    public void moveDown() {
        yPos += speed;
    }

    public void moveRight() {
        xPos += speed;
    }

    public void moveLeft() {
        xPos -= speed;
    }

}
