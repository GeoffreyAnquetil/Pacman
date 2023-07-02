package entities;

import main.GamePanel;
import main.KeyHandler;

import java.awt.*;

public class Player extends Entity{

    GamePanel gamePanel;
    KeyHandler keyHandler;

    public Player(GamePanel gp, KeyHandler kh){

        this.gamePanel = gp;
        this.keyHandler = kh;

        this.xPos = 100;
        this.yPos = 100;
        this.speed = 3; // Pixel/sec
    }

    public void update(){
        // Player movement
        if(keyHandler.upPressed) moveUp();
        else if(keyHandler.downPressed) moveDown();
        else if(keyHandler.rightPressed) moveRight();
        else if(keyHandler.leftPressed) moveLeft();
    }

    public void draw(Graphics2D g2){

        g2.fillRect(xPos, yPos, gamePanel.tileSize, gamePanel.tileSize);
        g2.dispose();

    }

    public void moveUp(){
        yPos -= speed;
    }

    public void moveDown(){
        yPos += speed;
    }

    public void moveRight(){
        xPos += speed;
    }

    public void moveLeft(){
        xPos -= speed;
    }

    public int getxPos() {
        return xPos;
    }

    public void setxPos(int xPos) {
        this.xPos = xPos;
    }

    public int getyPos() {
        return yPos;
    }

    public void setyPos(int yPos) {
        this.yPos = yPos;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
}
